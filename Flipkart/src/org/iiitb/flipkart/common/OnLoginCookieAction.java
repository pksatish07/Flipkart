package org.iiitb.flipkart.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.iiitb.flipkart.cart.CartDAO;
import org.iiitb.flipkart.cart.CartDAOImpl;
import org.iiitb.flipkart.login.User;

public class OnLoginCookieAction {

	
	
	public String execute()
	{
		String cartProductId="";
		String cartCount="0";
		Cookie cookie[] = ServletActionContext.getRequest().getCookies();
		for (Cookie temp : cookie) 
		{

			if (temp.getName().equalsIgnoreCase("CART_ITEMS_COUNT")) 
			{

				cartCount = temp.getValue();
			}

			if (temp.getName().equalsIgnoreCase("CART_ITEMS"))
			{
				cartProductId = temp.getValue();


			}
		}

		cartProductId = cartProductId.replaceAll("%2C", ",").replaceAll("%3A",":");

		/*       1) If cart count is non zero then there are items in cart
		 2) Add it to cart table
		 3) Fetch cart count  */


		
		
		
		String lg_id= String.valueOf(((User)ServletActionContext.getContext().getSession().get("User")).getLoginId());

		//String lg_id="1";
		Map<String,String> pid = new HashMap<String,String>();
		
		if(cartCount!="0")
		{
			StringBuffer query = new StringBuffer();
			ArrayList<String> queryList = new ArrayList<String>();
			// generate query
			String prod[] = cartProductId.split(",");

			for(int i=1;i<prod.length;i++)
			{
				query.append("(");

				query.append(prod[i].split(":")[0]+",");

				query.append(prod[i].split(":")[1]+",");


				query.append(lg_id);
				query.append(")");

				pid.put(prod[i].split(":")[0],prod[i].split(":")[1]);
				queryList.add(query.toString());
				query = new StringBuffer();
			}

			//int replace = query.lastIndexOf(",");


				
			
			System.out.println("Before call");
			
			
			CartDAO fetchCart = new CartDAOImpl();
			fetchCart.addCartItems(queryList,pid,lg_id);






			
		}
		
		return "success";
	}
	
}
