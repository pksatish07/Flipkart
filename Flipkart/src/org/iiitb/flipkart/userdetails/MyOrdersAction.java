package org.iiitb.flipkart.userdetails;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyOrdersAction extends ActionSupport implements SessionAware {

	public Map<String, Object> getSession() {
		return session;
	}
	public static String getUser() {
		return USER;
	}
	private static final long serialVersionUID = 1L;
	private List<MyOrderInfo> resultList;
	private Map<String, Object> session;
	private static final String USER = "User";

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
	public String execute() throws Exception {
		//System.out.println("hai from action execute");

		User user = (User) this.session.get("User");
		//User user = ActionContext.getContext().getSession.
		if (user != null) {

			setResultList(new MyOrderDaoImpl().getmyorders(user.getLoginId()));
			
			for(MyOrderInfo m : resultList){
				System.out.println(m.getProductId());
			}
			
			
			return SUCCESS;
		} else
			return LOGIN;
	}
	public List<MyOrderInfo> getResultList() {
		return resultList;
	}
	public void setResultList(List<MyOrderInfo> resultList) {
		this.resultList = resultList;
	}
}
