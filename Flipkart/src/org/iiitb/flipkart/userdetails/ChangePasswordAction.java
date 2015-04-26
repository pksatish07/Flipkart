package org.iiitb.flipkart.userdetails;

import java.sql.Connection;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;
import com.opensymphony.xwork2.ActionSupport;
import com.flipkart.util.ConnectionPool;



public class ChangePasswordAction extends ActionSupport implements SessionAware{
  /**
	 * 
	 */
	private static final long serialVersionUID = 7864856097727517295L;
private  String email;
  private  String oldpassword;
  private  String newpassword;
  private String retype;
  private Map<String, Object> session;
	
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getRetype() {
		return retype;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	public String initialize() throws Exception{
		String result=SUCCESS;
		User user = (User) session.get("User");
		if (user != null)
		{   
			setEmail(session.get("mailID").toString());
			 result=SUCCESS;
			
		}
		else{
			result=ERROR;
		}

		return result;
		
	}
public String execute() throws Exception
{    String result=SUCCESS;
User user = (User) session.get("User");
	if (user != null)
	{   
		if(user.getPassword().equals(getOldpassword()) && getRetype().equals(getNewpassword()))
		{
			new MyAccountDaoImpl().ChangePassword(user.getMailId(),getNewpassword());
			user.setPassword(getNewpassword());
			ServletActionContext.getResponse().addHeader("flag","true");
		}else{ServletActionContext.getResponse().addHeader("flag","false");}
	}
	else{
		result= ERROR;
	}

	return result;
}
@Override
public void setSession(Map<String, Object> session)
{
	this.session = session;

}


}
