package org.iiitb.flipkart.common;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor,RequestAware{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -2799348281841811478L;

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{

		
		
		// Directly used request.getSession(false) 
		

		HttpServletRequest req = (HttpServletRequest)ServletActionContext.getRequest();
	
		
		
			
			
			// Fetch old session id from request
			
			Cookie temp[] = req.getCookies();
			for(Cookie cookie:temp)
			{
				if(cookie.getName().equalsIgnoreCase("CUSTOMID"))
					System.out.println(cookie.getValue());
				
			}
			
			
			/*// Create a new session
			
			session = req.getSession();
			newSessionId = session.getId();
			
			// Overwrite the existing JSESSIONID cookie. We change only the MaxAge of the
			// cookie to 2 weeks.
			
			HttpServletResponse res =  (HttpServletResponse)ServletActionContext.getResponse();
			Cookie cookie = new Cookie("JSESSIONID",newSessionId);
			cookie.setMaxAge(60 * 60 * 24 * 14);
			res.addCookie(cookie);
			*/
			
			
			// Make database table changes
			
			
			// Make changes to cart table and recommendation table
			
			
			
			
			
			
			
			
			
		
		
		
	
		
		return actionInvocation.invoke();
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}


	

}




