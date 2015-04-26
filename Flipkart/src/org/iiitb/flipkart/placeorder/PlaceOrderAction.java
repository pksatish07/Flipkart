package org.iiitb.flipkart.placeorder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.common.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class PlaceOrderAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String CustomerName;
	private int PinCode;
	private String Address;
	private String LandMark;
	private int Phone;
	
	public int getPinCode() {
		return PinCode;
	}

	public void setPinCode(int pinCode) {
		PinCode = pinCode;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	private String mailID;
public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}


	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getLandMark() {
		return LandMark;
	}

	public void setLandMark(String landMark) {
		LandMark = landMark;
	}
	public String addNewAddress() throws NamingException, SQLException
	{
		System.out.println(CustomerName);
		
		Connection conn = ConnectionPool.getConnection();
		PlaceOrderDao pl= new PlaceOrderImpl();
		
		pl.addUserAddress(conn,CustomerName,PinCode,Address,LandMark,Phone,mailID);
		message="success";
		ConnectionPool.freeConnection(conn);
		
		return SUCCESS;
	}
	
	
	public String deleteAddress() throws NamingException, SQLException
	{
		
		Connection conn = ConnectionPool.getConnection();
		PlaceOrderDao pl= new PlaceOrderImpl();
		
		pl.deleteAddress(conn,mailID);
		message="success";
		ConnectionPool.freeConnection(conn);
		
		return SUCCESS;
	}
	
	

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}
}
