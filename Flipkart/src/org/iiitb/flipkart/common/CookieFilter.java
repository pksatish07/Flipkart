package org.iiitb.flipkart.common;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class CookieFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2799348281841811478L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		 

		boolean custIdFlag = false;
		boolean cartItemsFlag = false;
		boolean browseItemsFlag = false;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// Check if custom_id is present in the request

		Cookie temp[] = req.getCookies();
		for (Cookie cookie : temp) {
			if (cookie.getName().equalsIgnoreCase("CUSTOMID"))

			{
				custIdFlag = true;

			}

			if (cookie.getName().equalsIgnoreCase("CART_ITEMS_COUNT")) {
				cartItemsFlag = true;
			}
			
			if (cookie.getName().equalsIgnoreCase("BROWSE_ITEM")) {
				browseItemsFlag = true;
			}

		}

		// If the cookie is not present add it.
		// The max age of cookie is set to 30 days

		if (!custIdFlag) {
			Cookie cookie = new Cookie("CUSTOMID", UUID.randomUUID().toString());
			cookie.setMaxAge(60 * 60 * 24 * 30);
			// cookie.setDomain("http://localhost:8080/kartilla/");
			res.addCookie(cookie);
	
		}

		// The max age of cookie is set to 7 days
		if (!cartItemsFlag) {
			
			//System.out.println("entered");
			Cookie cookie = new Cookie("CART_ITEMS_COUNT", String.valueOf(0));
			cookie.setMaxAge(60 * 60 * 24 * 7);
			res.addCookie(cookie);

			cookie = new Cookie("CART_ITEMS", "");
			cookie.setMaxAge(60 * 60 * 24 * 7);
			res.addCookie(cookie);
		}
		
		
		if (!browseItemsFlag) {
			Cookie cookie = new Cookie("BROWSE_ITEM", "");
			cookie.setMaxAge(60 * 60 * 24 * 30);
			res.addCookie(cookie);
	
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
