package org.iiitb.flipkart.common;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport {
	
	public String execute()
	{
		System.out.println("hi !!!!!");
		return "success";
	}
}
