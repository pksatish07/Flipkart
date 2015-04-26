package org.iiitb.flipkart.userdetails;

import java.util.List;



public interface MyOrderDao {
	public List<MyOrderInfo> getmyorders(int emailid);
	public MyOrderInfo getproductimage(int productID);
}
