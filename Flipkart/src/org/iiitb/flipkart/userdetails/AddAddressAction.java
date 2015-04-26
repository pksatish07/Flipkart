package org.iiitb.flipkart.userdetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;
import com.flipkart.util.ConnectionPool;
import com.opensymphony.xwork2.ActionSupport;

public class AddAddressAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String name;
	private  String street;
	private  String landmark;
	private  String city;
	private  String state;
	private  int pincode;
	private  long mobile;
	private Map<String, Object> session;

	
	public String execute() throws NamingException, SQLException{
		String ret = ERROR;  
		User user = (User) session.get("User");
		if (null != user) {
			Connection conn = ConnectionPool.getConnection();
			ResultSet generatedKeys = null;
			PreparedStatement preStmt = null;
			
			try { 
				
				String ADD_ADDRESS="insert into flipkart.address (customername,address,landmark,city,state,pincode,phoneno,l_id) values (?,?,?,?,?,?,?,?)";
				preStmt = conn.prepareStatement(ADD_ADDRESS);			
				preStmt.setString(1,getName());			
				preStmt.setString(2,getStreet());
				preStmt.setString(3,getLandmark());
				preStmt.setString(4,getCity());
				preStmt.setString(5,getState());
				preStmt.setInt(6,getPincode());
				preStmt.setLong(7,getMobile());	
				preStmt.setInt(8,user.getLoginId());			
				  if (preStmt.executeUpdate() > 0)
				        ServletActionContext.getResponse().addHeader("flag","true");//ret = SUCCESS;
				      else
				    	  ServletActionContext.getResponse().addHeader("flag","false");// ret = ERROR;

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				ConnectionPool.freeConnection(conn);
			}
		}else {
			ret=ERROR;
		}
		return ret;
	}


	public String getName() {
		return name;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	
	@Override

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	



}
