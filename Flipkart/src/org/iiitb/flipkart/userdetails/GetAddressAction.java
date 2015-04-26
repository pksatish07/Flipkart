package org.iiitb.flipkart.userdetails;
import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;


import org.iiitb.flipkart.login.User;

import com.opensymphony.xwork2.ActionSupport;

public class GetAddressAction  extends ActionSupport implements SessionAware {
	public Map<String, Object> getSession() {
		return session;
	}
	
	private static final long serialVersionUID = 1L;
	private List<AddressInfo> resultList;
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
public String execute() throws Exception {

	
	 User user = (User) session.get("User");
		if (user != null) {
	 setResultList(new MyAccountDaoImpl().getAddress(user.getMailId()));
			return SUCCESS;
			
		} else
			return ERROR;
	}
public List<AddressInfo> getResultList() {
		return resultList;
	}
public void setResultList(List<AddressInfo> resultList) {
		this.resultList = resultList;
	}
}





















