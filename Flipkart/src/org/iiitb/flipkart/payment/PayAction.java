package org.iiitb.flipkart.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.stock.UpdateStock;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PayAction extends ActionSupport implements SessionAware{

	private long cardNumber;
	private String expDate;
	private int cvv;
	private String nameOnCard;
	private boolean isValid;
	private int amount;
	//seller id , order cost
	private HashMap<Integer,ArrayList<Integer>> order_cost;
	private SessionMap<String, Object> session;
	private String addressID;
	//private int seller_id;
	private boolean notEnoughBalance = false;
	

	CreditCardDetails cd;
	int totalcost;
	HashMap<Integer,Integer> p_ids;
	//int change_in_amount;
	HashMap<Integer,ArrayList<Integer>> s_c;
	
	public HashMap<Integer, ArrayList<Integer>> getOrder_cost() {
		return order_cost;
	}
	public boolean isNotEnoughBalance() {
		return notEnoughBalance;
	}
	public void setNotEnoughBalance(boolean notEnoughBalance) {
		this.notEnoughBalance = notEnoughBalance;
	}
	public String getAddressID() {
		return addressID;
	}
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}
	public void setOrder_cost(HashMap<Integer, ArrayList<Integer>> order_cost) {
		this.order_cost = order_cost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String execute(){

		System.out.println(cardNumber);
		System.out.println(expDate);
		System.out.println(cvv);
		System.out.println(nameOnCard);
		System.out.println(addressID);


		PaymentDaoImpl pd = new PaymentDaoImpl();
		
		cd = pd.c_pay(this);
		//System.out.println(cd.getcCardNo());


		if(cd.getcCardNo() == 0){
			setValid(false);
			return ERROR;
		}else if((!(cd.getExpDate().equalsIgnoreCase(expDate))) && (cd.getCvv() != cvv) && (!cd.getNameOnCard().equalsIgnoreCase(nameOnCard))){
			setValid(false);
			return ERROR;
		}else{
			setValid(true);
			
			s_c = (HashMap<Integer, ArrayList<Integer>>) session.get("sidcost");
			List<Integer> costs ;
			int total=0;
			
			for(Map.Entry<Integer,ArrayList<Integer>> cost : s_c.entrySet()){
				costs = cost.getValue();
				for(Integer i:costs){
					total +=i;
				}
			}
			
			setAmount(total);
			System.out.println("Total Cost:"+getAmount());
			
			boolean canTransfer = transeferAmount();
			
			if(canTransfer){
				
				UpdateStock update = new UpdateStock();
				//need list of pids and p_quantity
				
				p_ids = new HashMap<Integer,Integer>();
				p_ids.put(1, 1);
				p_ids.put(5, 1);
				
				for(Map.Entry<Integer, Integer> e : p_ids.entrySet()){
					
					update.afterPayment(e.getKey(), e.getValue());
				}
								
				//remove data from cart and update data in place order
				// need a_id , login id, seller ids , product ids ,prod quantity
				
				UpdatePlaceOrderDAOImpl updt = new UpdatePlaceOrderDAOImpl();
				String stat = updt.updatePlaceOrder(1);
				
				return SUCCESS;
			}else if(!canTransfer){
				return "balance";
			}
			else{
				return ERROR;
			}
		}

	}
	
	public boolean transeferAmount(){
		System.out.println("Available balance :"+cd.getAvailbalance());
		System.out.println("Cost :"+getAmount());
		if(getAmount() < cd.getAvailbalance()){
			System.out.println("Amount : "+getAmount() +" availbal:"+cd.getAvailbalance());
			setNotEnoughBalance(true);
			session.put("balance", isNotEnoughBalance());
			transfermoney();
			return true;
		}else{
			//System.out.println("Here !!!");
			return false;
		}
	}
	
	public void transfermoney(){
		
		// = new HashMap<Integer,List<Integer>>();
		HashMap<Integer,Integer> pid_seller;
		
		s_c = (HashMap<Integer, ArrayList<Integer>>) session.get("sidcost");
		//s_c = (HashMap<Integer, ArrayList<Integer>>)ServletActionContext.getRequest().getAttribute("sidcost");
		//pid_seller = (HashMap<Integer,Integer>)session.get("sidProdSellDetails");
		session.remove("sidcost");
		
		
		/*for(Map.Entry<Integer, ArrayList<Integer>> s : s_c.entrySet()){
			//System.out.println("Key"+s.getKey());
			for(Integer i:s.getValue()){
				//System.out.print("value"+i);
			}
			System.out.println("");
		}*/
		//Hardcoded values
		/*List<Integer> c = new ArrayList<Integer>();
		c.add(4000);
		c.add(5000);
		s_c.put(1,c);
		setAmount(9000);*/
		//
		
		
		HashMap<Integer,Integer> s_amount = new HashMap<Integer,Integer>();
		List<Integer> costs ;
		int total=0;
		
		for(Map.Entry<Integer,ArrayList<Integer>> cost : s_c.entrySet()){
			costs = cost.getValue();
			totalcost = 0;
			for(Integer i:costs){
				totalcost += i; 
				total +=i;
			}
			System.out.println("Total cost :"+totalcost);
			s_amount.put(cost.getKey(), totalcost);
		}
		
		setAmount(total);
		System.out.println("total amount : "+getAmount());
		//if seller ids are same sum the costs of the products
		
		setOrder_cost(s_c);
		cd.setAvailbalance(cd.getAvailbalance()-getAmount());
		PaymentDaoImpl pdimpl = new PaymentDaoImpl();
		pdimpl.transferAmt(cd,s_amount);
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap<String, Object>) session;
		
	}
}
