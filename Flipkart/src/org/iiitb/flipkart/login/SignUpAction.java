package org.iiitb.flipkart.login;

import java.sql.Connection;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.common.ConnectionPool;
import org.iiitb.flipkart.common.OnLoginCookieAction;

import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> session;
	private String SignupId;
	private String SignUpPassId;
	private String RepeatPassId;

	public String SignUp(){
		String UserType="N";
		loginDAO signUp=new loginDAOimpl();
		//System.out.println(SignupId+SignUpPassId+UserType);
		Connection connection = ConnectionPool.getConnection();
		boolean SignupComplete=signUp.signUpNewUser(connection,SignupId,SignUpPassId,UserType);
		ConnectionPool.freeConnection(connection);
		if(SignupComplete){
			User user = new User();
			session.put("mailID", SignupId);
			Connection conn = ConnectionPool.getConnection();
			
			loginDAO userVo=new loginDAOimpl();
			user=userVo.getUser(conn,SignupId);
			ConnectionPool.freeConnection(connection);
			System.out.println(user.getFirstName()+user.getLoginId()+user.getMailId());
			session.put("User", user);
			OnLoginCookieAction cookie = new OnLoginCookieAction();
			System.out.println("cookie status "+cookie.execute());
			return SUCCESS;
		}
		else {
			
			return ERROR;
		}
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

	public String getSignupId() {
		return SignupId;
	}

	public void setSignupId(String signupId) {
		SignupId = signupId;
	}

	public String getSignUpPassId() {
		return SignUpPassId;
	}

	public void setSignUpPassId(String signUpPassId) {
		SignUpPassId = signUpPassId;
	}


	public String getRepeatPassId() {
		return RepeatPassId;
	}


	public void setRepeatPassId(String repeatPassId) {
		RepeatPassId = repeatPassId;
	}

}
