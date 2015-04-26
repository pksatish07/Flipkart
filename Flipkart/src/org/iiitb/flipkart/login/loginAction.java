package org.iiitb.flipkart.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.common.ConnectionPool;






import org.iiitb.flipkart.common.OnLoginCookieAction;

import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String flag="N";
	private String mailID ; 
	private String password;
	private String error;

	private String message;


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
	
	public String logout() throws NamingException, SQLException
	{
		String mail;
		session.remove("mailID");
		session.remove("User");
		session.clear();
		session.invalidate();
		mail= (String) session.get("mailID");
		
		if(mail!=null)
		{
			System.out.println("failed logout");
			return "failure";
		}
		else
		{
			System.out.println(mail+"username success logout");
			return SUCCESS;
		}
	}
	

	
	public String login() throws NamingException, SQLException
	{
		
		/*String mail =  (String) session.get("mailID");
		if (mail != null)
		{
			message="home";
			return SUCCESS;
		}
		else
		{*/

			if (isValidUser(mailID,password))
			{

				User user = new User();
				System.out.println("is valid");
				session.put("mailID", mailID);
				Connection connection = ConnectionPool.getConnection();
				
				loginDAO userVo=new loginDAOimpl();
				user=userVo.getUser(connection,mailID);
				ConnectionPool.freeConnection(connection);
				System.out.println(user.getFirstName()+user.getLoginId()+user.getMailId());
				session.put("User", user);
				loginDAO UT=new loginDAOimpl();
				 connection = ConnectionPool.getConnection();
				String userType=UT.getUserType(mailID,connection);
				ConnectionPool.freeConnection(connection);
				if (userType.equalsIgnoreCase("A"))
				{
					message="admin";
					return SUCCESS;
				}

				setFlag("L");

				message="home";
			System.out.println("In login action "+session.get("UserName"));
			
			// Cookie call
			
			OnLoginCookieAction cookie = new OnLoginCookieAction();
			System.out.println("cookie status "+cookie.execute());
			
			
			return SUCCESS;
			}
			else
			{
				System.out.println("not valid");
				message="error";
				return SUCCESS;
			}

		}

	/*}*/



	private boolean isValidUser(String Email,String Upassword)
	{

		Connection conn = ConnectionPool.getConnection();
		loginDAO MailCheck= new loginDAOimpl();
		boolean validMail=MailCheck.CheckUserMailId(conn, Email,Upassword);
		ConnectionPool.freeConnection(conn);
		return validMail;
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


}
