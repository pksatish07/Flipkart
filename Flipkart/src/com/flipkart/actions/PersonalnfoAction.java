package com.flipkart.actions;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;
import org.iiitb.flipkart.login.loginDAO;
import org.iiitb.flipkart.login.loginDAOimpl;

import com.flipkart.util.ConnectionPool;
import com.opensymphony.xwork2.ActionSupport;

public class PersonalnfoAction extends ActionSupport implements SessionAware  {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname; 
	  private String lastname;
	  private long mobile;
	  public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	private String landline;
	  private String gender;
	 
	  private Map<String, Object> session;
	 
	  
	  
	  public String initialize() throws Exception{
			String result=SUCCESS;
			User user = new User();
			Connection connection = ConnectionPool.getConnection();
			
			loginDAO userVo=new loginDAOimpl();
			user=userVo.getUser(connection,session.get("mailID").toString());
			
			ConnectionPool.freeConnection(connection);
			System.out.println(user.getFirstName()+user.getLoginId()+user.getMailId());
			session.put("User", user);
			
			    setFirstname(user.getFirstName());
				setLastname(user.getLastName());
				setLandline(user.getLandLine());
				setGender(user.getGender());
				setMobile(user.getMobileNo());
				setMailId(user.getMailId());
				System.out.println("landline==="+user.getLandLine());
				System.out.println("mobile==="+user.getMobileNo());
				 result=SUCCESS;
				
			

			return result;
			
		}
	  private void setMailId(String mailId) {
		// TODO Auto-generated method stub
		
	}
	public String execute() throws NamingException, SQLException{
       
		  String ret = ERROR;
		  User user = (User) session.get("User");
		    if (user != null) {
		    	Connection conn = ConnectionPool.getConnection();
		    	
		    	PreparedStatement preStmt;
		    	try {
		    		
        
	  String query = "UPDATE flipkart.login SET l_firstname =?,l_lastname =?,l_mobileno =?,landline=?,gender=? where (login.l_mailid =? and login.l_password=?);";

      preStmt = conn.prepareStatement(query);
      preStmt.setString(1,getFirstname());
      preStmt.setString(2,getLastname());
      preStmt.setLong(3,getMobile());
      preStmt.setString(4,getLandline());
      preStmt.setString(5,getGender());
      preStmt.setString(6,user.getMailId());
      preStmt.setString(7,user.getPassword());
    
     
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
		        ret= ERROR;
		    }
    return NONE;

  }
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
