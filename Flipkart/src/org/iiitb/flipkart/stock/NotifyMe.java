package org.iiitb.flipkart.stock;
import com.opensymphony.xwork2.Action;
public class NotifyMe implements Action {

	private static final String NULL = null;
	private int p_id;
	private String email_id;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public String execute()
	{
		String result;
		System.out.println(p_id +" "+email_id);
		NotifyMeDAO notifymedao=new NotifyMeDAOImpl();
		result=notifymedao.notifyRequest(p_id, email_id);
		
		if(result==NULL)
		
			return ERROR;
		
		else
			return SUCCESS;
	}
}
