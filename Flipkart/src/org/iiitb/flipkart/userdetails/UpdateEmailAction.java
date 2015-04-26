package org.iiitb.flipkart.userdetails;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateEmailAction extends ActionSupport implements SessionAware{
  /**
	 * 
	 */
	private static final long serialVersionUID = -3905557011058414041L;
private  String newemailid;
private  String email;
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Map<String, Object> getSession() {
	return session;
}
public void setSession(Map<String, Object> session) {
	this.session = session;
}

private Map<String, Object> session;
 
	
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
 			
 				 new MyAccountDaoImpl().UpdateEmail(user.getMailId(),getNewemailid());
 				session.put("mailID", getNewemailid());
 				 user.setMailId(getNewemailid());
 				ServletActionContext.getResponse().addHeader("flag","true");
 			
 		}
 		else{
 			result= ERROR;
 		}

 		return result;

 	}
	public String getNewemailid() {
		return newemailid;
	}
	public void setNewemailid(String newemailid) {
		this.newemailid = newemailid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 	
  
}
