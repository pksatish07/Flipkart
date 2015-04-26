package org.iiitb.flipkart.userdetails;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;

import com.flipkart.daoimpl.*;
import com.opensymphony.xwork2.ActionSupport;

public class DeactivateAccountAction extends ActionSupport implements SessionAware {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
 	
 	private  String email;
 	private  String password;
 	
 	public String initialize() throws Exception{
		String result=SUCCESS;
		User user = (User) session.get("User");
		if (user != null)
		{   		
			setEmail(session.get("mailID").toString());
			 result=SUCCESS;
			
		}
		else{
			result= ERROR;
		}
		return result;
		
	}
 	public String execute() throws Exception
 	{    String result=ERROR;
 		User user = (User) this.session.get("User");
 		if (user != null)
 		{   
 			if(user.getPassword().equals(getPassword()))
 			{
 				new MyAccountDaoImpl().deactivateAccount(user.getMailId(),getPassword());
 				ServletActionContext.getResponse().addHeader("flag","true");
 			}else{ServletActionContext.getResponse().addHeader("flag","false");}
 				
 		}
 		else{
 			result= ERROR;
 		}

 		return result;

 	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
