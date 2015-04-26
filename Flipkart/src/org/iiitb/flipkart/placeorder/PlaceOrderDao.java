package org.iiitb.flipkart.placeorder;

import java.sql.Connection;

public interface PlaceOrderDao {
	public boolean addUserAddress(Connection conn,String CustomerName,int PinCode,String Address,String LandMark,int Phone,String Email);
	public boolean deleteAddress(Connection conn,String Email);
}
