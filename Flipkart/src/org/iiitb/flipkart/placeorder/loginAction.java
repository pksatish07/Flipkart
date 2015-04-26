package org.iiitb.flipkart.placeorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.cart.CartDAO;
import org.iiitb.flipkart.cart.CartDAOImpl;
import org.iiitb.flipkart.cart.CartVO;
import org.iiitb.flipkart.common.ConnectionPool;
import org.iiitb.flipkart.login.User;












import org.iiitb.flipkart.common.OnLoginCookieAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport implements SessionAware,Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String flag="N";
	private String mailID ; 
	private String password;
	private String error;
	private ArrayList<CartVO> resultSet;
	private int loginId;
	private int total;
	private String message2;
	private String tabToGo;
	private Map<Integer,ArrayList<Integer>> payment;
	private Map<Integer,Integer> prodSellDetailsMap;
	
	
	public String getTabToGo() {
		return tabToGo;
	}

	public void setTabToGo(String tabToGo) {
		this.tabToGo = tabToGo;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartVO> getResultSet() {
		return resultSet;
	}

	public void setResultSet(ArrayList<CartVO> resultSet) {
		this.resultSet = resultSet;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int quantity;
	private int id;
	private String cartCount;
	private String checkmailincookie;
	
	

	public String getCheckmailincookie() {
		return checkmailincookie;
	}

	public void setCheckmailincookie(String checkmailincookie) {
		this.checkmailincookie = checkmailincookie;
	}

	private String message;
private String message1;

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private SessionMap<String, Object> session;
	
	
	public String checkUser() throws NamingException, SQLException
	{
		if (userexists(mailID))
		{
				message="exists";
		return SUCCESS;
		}
		else
		{
			
			message="dexistsss";
			return SUCCESS;
		}

	}
	
	
	public String login() throws NamingException, SQLException
	{
			if (isValidUser(mailID,password))
			{

				User user = new User();
				session.put("mailID", mailID);
				Connection connection = ConnectionPool.getConnection();
				
				org.iiitb.flipkart.login.loginDAO usr=new org.iiitb.flipkart.login.loginDAOimpl();
				user=usr.getUser(connection,mailID);
				ConnectionPool.freeConnection(connection);
				session.put("User", user);
				message="correctpassword";
				OnLoginCookieAction cookie = new OnLoginCookieAction();
				System.out.println("cookie status in PlaceOrder "+cookie.execute());
			return SUCCESS;
			}
			else
			{
				message="wrong";
				return SUCCESS;
			}

		}

	/*}*/

	public String signup() throws NamingException, SQLException
	{
		Connection conn = ConnectionPool.getConnection();
		loginDAO lg= new loginDAOimpl();
		lg.AddUser(conn, mailID,password);
		setMessage1("true");
		ConnectionPool.freeConnection(conn);
		
		User user = new User();
		session.put("mailID", mailID);
		Connection connection = ConnectionPool.getConnection();
		
		org.iiitb.flipkart.login.loginDAO usr=new org.iiitb.flipkart.login.loginDAOimpl();
		user=usr.getUser(connection,mailID);
		ConnectionPool.freeConnection(connection);
		session.put("User", user);
		OnLoginCookieAction cookie = new OnLoginCookieAction();
		System.out.println("cookie status in PlaceOrder "+cookie.execute());
		return SUCCESS;
		
	}
	private boolean userexists(String Email)
	{

		Connection conn = ConnectionPool.getConnection();
		loginDAO MailCheck= new loginDAOimpl();
		boolean validMail=MailCheck.CheckUserMailId(conn, Email);
		ConnectionPool.freeConnection(conn);
		return validMail;
	}
	
	

	
	private boolean isValidUser(String Email,String Upassword)
	{

		Connection conn = ConnectionPool.getConnection();
		loginDAO MailCheck= new loginDAOimpl();
		boolean validMail=MailCheck.CheckUserMailId(conn, Email,Upassword);
		ConnectionPool.freeConnection(conn);
		return validMail;
	}
	
	
	public String execute() {
		
		System.out.println("Entered ganesh");
		
		Map<Integer,ArrayList<Integer>> addPayment = new HashMap<Integer,ArrayList<Integer>>();
		Map<Integer,Integer> prodDetails = new HashMap<Integer,Integer>();
		if(ServletActionContext.getRequest().getSession().getAttribute("User")==null)
		{
			// This scenario never comes in case of cart in placeorder
			checkmailincookie="absent";
			System.out.println(checkmailincookie);
			return "success";
		
		}
		else
		{
			
			mailID= ((User) ServletActionContext.getRequest().getSession().getAttribute("User")).getMailId();
			checkmailincookie="present";
			System.out.println(checkmailincookie);
		setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());
		CartDAO fetchCart = new CartDAOImpl();
		setResultSet((ArrayList<CartVO>) fetchCart.fetchCartItems(getLoginId()));
		setCartCount(String.valueOf(fetchCart.fetchCartCount(String.valueOf(getLoginId()))));
		Iterator iter = resultSet.iterator();
		int calcTotal = 0;
		CartVO temp = new CartVO();
		while (iter.hasNext()) {

			temp = (CartVO) iter.next();
			temp.setTotalPrice((temp.getPrice() + temp.getDeliveryCharge())
					* temp.getQuantity());
			calcTotal += temp.getTotalPrice();
			prodDetails.put(temp.getProductId(), temp.getSellerId());
			if(addPayment.get(temp.getSellerId())!=null)
			{
				addPayment.get(temp.getSellerId()).add(temp.getTotalPrice());
			}
			else
			{
				ArrayList<Integer> addList = new ArrayList<Integer>();
				addList.add(temp.getTotalPrice());
				addPayment.put(temp.getSellerId(), addList);
			}

		}
		setTotal(calcTotal);
		setTabToGo("accordion3");
		setPayment(addPayment);
		setProdSellDetailsMap(prodDetails);
		
		
		session.put("prodselldetails", getProdSellDetailsMap());
		session.put("sidcost", addPayment);
		
		/*HashMap<Integer,ArrayList<Integer>> m = (HashMap<Integer, ArrayList<Integer>>)session.get("sidcost");
		
		for(Map.Entry<Integer, ArrayList<Integer>> s : m.entrySet()){
		System.out.println("Key"+s.getKey());
		for(Integer i:s.getValue()){
			System.out.print("value"+i);
		}
		System.out.println("");*/
		
		
	}

		return "success";
		}
		
	
public String update() {

	setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());

		CartDAO fetchCart = new CartDAOImpl();
		fetchCart.changeCartItems(getId(), getQuantity(), getLoginId());
		return "success";
	}
	
	
	
	
	
public String remove() {

	//ServletActionContext.getRequest().getSession().getAttribute("User").getLoginId();
	setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());

	CartDAO fetchCart = new CartDAOImpl();

	fetchCart.removeCartItems(getId(), getLoginId());
	return "success";
}


public String addCartOnSession()
{
	
	
	System.out.println("entered success");
	setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());

	Map<String,String> pid = new HashMap<String,String>();
	ArrayList<String> queryAssist = new ArrayList<String>();
	
	String temp1 = "("+getId()+",1"+","+getLoginId()+")";
	queryAssist.add(temp1);
	// hardcoded 1 here is quantity. it should remain so.
	pid.put(String.valueOf(getId()),"1");
	CartDAO fetchCart = new CartDAOImpl();
	fetchCart.addCartItems(queryAssist, pid, String.valueOf(getLoginId()));
	message = String.valueOf(fetchCart.fetchCartCount(String.valueOf(getLoginId())));
	return SUCCESS;
	
}



	public String getCartCount() {
		return cartCount;
	}

	public void setCartCount(String cartCount) {
		this.cartCount = cartCount;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes)
	{
		this.session = (SessionMap<String, Object>)sessionAttributes;	
	}

	public SessionMap<String, Object> getSession()
	{
		return session;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public Map<Integer,ArrayList<Integer>> getPayment() {
		return payment;
	}

	public void setPayment(Map<Integer,ArrayList<Integer>> payment) {
		this.payment = payment;
	}

	public Map<Integer,Integer> getProdSellDetailsMap() {
		return prodSellDetailsMap;
	}

	public void setProdSellDetailsMap(Map<Integer,Integer> prodSellDetailsMap) {
		this.prodSellDetailsMap = prodSellDetailsMap;
	}


}
