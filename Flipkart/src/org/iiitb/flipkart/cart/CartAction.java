package org.iiitb.flipkart.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.iiitb.flipkart.login.User;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	private ArrayList<CartVO> resultSet;
	private int loginId;
	private int total;
	private String message;
	private int quantity;
	private int id;
	private String cartCount;
	

	public String execute() {
		if(ServletActionContext.getRequest().getSession().getAttribute("mailID")==null)
		{
		String cartProductId="";
		cartCount = "0";
		Map<String,String> qtyMap = new HashMap<String,String>();
		
		Cookie cookie[] = ServletActionContext.getRequest().getCookies();
		for (Cookie temp : cookie) {
			if (temp.getName().equalsIgnoreCase("CART_ITEMS_COUNT")) {
				cartCount = temp.getValue();
				setCartCount(cartCount);
			}
			
			if (temp.getName().equalsIgnoreCase("CART_ITEMS")) {
				cartProductId = temp.getValue();
			}
		}
		
		cartProductId = cartProductId.replaceAll("%2C", ",").replaceAll("%3A",":");
		
/*       1) If cart count is non zero then there are items in cart
		 2) Add it to cart table
		 3) Fetch cart count  */
		
		 
		 //String lg_id= (User)session.getAttribute("User").getLoginId();
		 
			
		 if(cartCount!="0")
		{
			 StringBuffer query = new StringBuffer();
			 
		
			String prod[] = cartProductId.split(",");
			
			for(int i=1;i<prod.length;i++)
			{
				
				qtyMap.put(prod[i].split(":")[0],prod[i].split(":")[1]);
				query.append("'"+prod[i].split(":")[0]+"',");
				
				
				
			}
			
			int replace = query.lastIndexOf(",");
		
			// No item in cart check
			
			if(replace==-1 && prod.length==1)
			{
				System.out.println("entered");
				setResultSet(new ArrayList<CartVO>());
			}
			
			else
			{
			CartDAO fetchCart = new CartDAOImpl();
			setResultSet((ArrayList<CartVO>)fetchCart.getProdDetailsFromId(query.deleteCharAt(replace).toString(),qtyMap));
			}
			
				
			
		}
		 
		}
		
		else
		{
		setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());
		CartDAO fetchCart = new CartDAOImpl();
		setResultSet((ArrayList<CartVO>) fetchCart.fetchCartItems(getLoginId()));
		setCartCount(String.valueOf(fetchCart.fetchCartCount(String.valueOf(getLoginId()))));
		}
		Iterator iter = resultSet.iterator();
		int calcTotal = 0;
		CartVO temp = new CartVO();
		while (iter.hasNext()) {

			temp = (CartVO) iter.next();
			temp.setTotalPrice((temp.getPrice() + temp.getDeliveryCharge())
					* temp.getQuantity());
			calcTotal += temp.getTotalPrice();

		}

		setTotal(calcTotal);
		
		

		return "success";
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

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String update() {

		
		if(ServletActionContext.getRequest().getSession().getAttribute("mailID")==null)
		{
		String cartProductId="";
		String cartCount = "0";
		Cookie cookie[] = ServletActionContext.getRequest().getCookies();
		for (Cookie temp : cookie) {
			if (temp.getName().equalsIgnoreCase("CART_ITEMS_COUNT")) {
				cartCount = temp.getValue();
			}
			
			if (temp.getName().equalsIgnoreCase("CART_ITEMS")) {
				cartProductId = temp.getValue();
			}
		}
		
		cartProductId = cartProductId.replaceAll("%2C", ",").replaceAll("%3A",":");
		

		 
			
		
			 StringBuffer query = new StringBuffer();
			 
			// generate query
			String prod[] = cartProductId.split(",");
		
			for(int i=1;i<prod.length;i++)
			{
				
				
				if((prod[i].split(":")[0]).equalsIgnoreCase(String.valueOf(getId())))
				{
					cartProductId = cartProductId.replaceAll(prod[i],getId()+":"+getQuantity());
				}
				
				
			}
			
			Cookie cookie1 = new Cookie("CART_ITEMS", cartProductId);
			cookie1.setMaxAge(60 * 60 * 24 * 7);
		
			ServletActionContext.getResponse().addCookie(cookie1);
			
			
		
		
		 
		}
		 else
		 {
		
			 setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());
		CartDAO fetchCart = new CartDAOImpl();
		fetchCart.changeCartItems(getId(), getQuantity(), getLoginId());
		 }
		return "success";
	}

	public String remove() {
		
		
		if(ServletActionContext.getRequest().getSession().getAttribute("mailID")==null)
		{
		String cartProductId="";
		String cartCount = "0";
		Cookie cookie[] = ServletActionContext.getRequest().getCookies();
		for (Cookie temp : cookie) {
			if (temp.getName().equalsIgnoreCase("CART_ITEMS_COUNT")) {
				cartCount = temp.getValue();
			}
			
			if (temp.getName().equalsIgnoreCase("CART_ITEMS")) {
				cartProductId = temp.getValue();
			}
		}
		
		cartProductId = cartProductId.replaceAll("%2C", ",").replaceAll("%3A",":");
		

		 
			
		
			 StringBuffer query = new StringBuffer();
			 
			// generate query
			String prod[] = cartProductId.split(",");
		
			for(int i=1;i<prod.length;i++)
			{
				
			
				if((prod[i].split(":")[0]).equalsIgnoreCase(String.valueOf(getId())))
				{
					cartProductId = cartProductId.replaceAll(","+prod[i],"");
				}
				
				
			}
			
			Cookie cookie1 = new Cookie("CART_ITEMS", cartProductId);
			cookie1.setMaxAge(60 * 60 * 24 * 7);
			ServletActionContext.getResponse().addCookie(cookie1);
		
			
			cartCount=String.valueOf(Integer.parseInt(cartCount)-1);
			 cookie1 = new Cookie("CART_ITEMS_COUNT", String.valueOf(cartCount));
			cookie1.setMaxAge(60 * 60 * 24 * 7);
			ServletActionContext.getResponse().addCookie(cookie1);
			
		}
	else
	{
		//ServletActionContext.getRequest().getSession().getAttribute("User").getLoginId();
		setLoginId(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());
		CartDAO fetchCart = new CartDAOImpl();

		fetchCart.removeCartItems(getId(), getLoginId());
		
	}
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

	

}
