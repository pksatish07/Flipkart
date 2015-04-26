package org.iiitb.flipkart.placeorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlaceOrderImpl implements PlaceOrderDao {
	String GETLOGINID="SELECT login_id from login where l_mailid=?;";
	String ADDNEWUSERQUERY="INSERT into address(customername,pincode,address,landmark,phoneno,l_id) values(?,?,?,?,?,?);";
	String DELETE_USER_ADDRESS="DELETE from address where l_id=(SELECT login_id from login where l_mailid=?);";
	public boolean addUserAddress(Connection conn, String CustomerName,int PinCode,String Address,String LandMark,int Phone,String Email)
	{
		PreparedStatement ps = null;
		PreparedStatement ps2=null;
		try {
			ps2 = conn.prepareStatement(GETLOGINID);
			ps2.setString(1,Email);
			ResultSet result = ps2.executeQuery();
			if(result.next()){
				int loginid=result.getInt(1);
				ps = conn.prepareStatement(ADDNEWUSERQUERY);
				ps.setString(1,CustomerName);
				ps.setInt(2, PinCode);
				ps.setString(3, Address);
				ps.setString(4, LandMark);
				ps.setInt(5, Phone);
				ps.setInt(6,loginid);
				ps.executeUpdate();
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

	public boolean deleteAddress(Connection conn,String Email)
	{
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(DELETE_USER_ADDRESS);
			ps.setString(1,Email);
			
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	
	

}
