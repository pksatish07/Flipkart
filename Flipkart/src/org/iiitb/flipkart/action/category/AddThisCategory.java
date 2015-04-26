package org.iiitb.flipkart.action.category;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddThisCategory extends ActionSupport implements Action{
	
	private int notificationId;
	private String msg;
	
	
	public String execute(){
		
		//System.out.println(notificationId + " msg ="+msg);
		
		CategoryDAO addThis = new CategoryDAOImpl();
		if(msg.equals("add")){
		boolean result = addThis.addThisCategory(notificationId);
		if(result == false){
			msg = "error occured";
			
			//System.out.println("result = "+result);
			return ERROR;
		}
		//this.setMsg("New Category added successfully");
		//System.out.println("result = "+result);
		return SUCCESS;
		}
		
		else{
			CategoryDAO removeThis = new CategoryDAOImpl();
			
			boolean result = removeThis.removeFromNotify(notificationId);
			if(result == false){
				return ERROR;
			}
			return SUCCESS;
		}
		
	}
	
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
