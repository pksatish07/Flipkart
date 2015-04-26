package org.iiitb.flipkart.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

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
	//private int seller_id;
	
	

	CreditCardDetails cd;
	int totalcost;
	
	
	public HashMap<Integer, ArrayList<Integer>> getOrder_cost() {
		return order_cost;
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
			String canTransfer = transeferAmount();
			
			if(canTransfer.equalsIgnoreCase("success")){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}

	}
	
	public String transeferAmount(){
		if(getAmount() > cd.getAvailbalance()){
			return "error";
		}else{
			transfermoney();
			return "success";
		}
	}
	
	public void transfermoney(){
		
		HashMap<Integer,ArrayList<Integer>> s_c;// = new HashMap<Integer,List<Integer>>();
		
		s_c = (HashMap<Integer, ArrayList<Integer>>) session.get("sidcost");
		
		for(Map.Entry<Integer, ArrayList<Integer>> s : s_c.entrySet()){
			System.out.println("Key"+s.getKey());
			for(Integer i:s.getValue()){
				System.out.print("value"+i);
			}
			System.out.println("");
		}
		//Hardcoded values
		/*List<Integer> c = new ArrayList<Integer>();
		c.add(4000);
		c.add(5000);
		s_c.put(1,c);
		setAmount(9000);*/
		//
		
		
		HashMap<Integer,Integer> s_amount = new HashMap<Integer,Integer>();
		List<Integer> costs ;
		
		
		for(Map.Entry<Integer,ArrayList<Integer>> cost : s_c.entrySet()){
			costs = cost.getValue();
			totalcost = 0;
			for(Integer i:costs){
				totalcost += i; 
			}
			s_amount.put(cost.getKey(), totalcost);
		}
		
		
		
		
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
