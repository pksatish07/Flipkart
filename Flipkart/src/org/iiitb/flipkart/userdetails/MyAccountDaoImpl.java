package org.iiitb.flipkart.userdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.iiitb.flipkart.userdetails.AddressInfo;
import com.flipkart.util.ConnectionPool;

public class MyAccountDaoImpl  implements MyAccountDao{
	private List<AddressInfo> resultList = new ArrayList<AddressInfo>();
	private static final String DEACTIVE="UPDATE login SET l_mode='D' where l_mailid =? and l_password=?;";
	private static final String UPDATE_PSW="UPDATE login SET l_password=? where l_mailid =?";
	private static final String UPDATE_EMAIL="UPDATE login SET l_mailid=? where l_mailid =?;";
	private static final String VIEW_ADDRESSES="select customername,address,landmark,city,phoneno,pincode,state from address,login where l_id=login_id and l_mailid=?;";
	
public List<AddressInfo> getAddress(String mail) {
	
	Connection con = ConnectionPool.getConnection();
	PreparedStatement ps = null;
	AddressInfo address;
	ResultSet rs;
	try
	{
		ps = con.prepareStatement(VIEW_ADDRESSES);
		ps.setString(1, mail);
		rs = ps.executeQuery();
		while (rs.next())
		{       address= new AddressInfo();
		address.setAd_name(rs.getString("customername"));		 
		address.setStreet(rs.getString("address"));
		address.setLandmark(rs.getString("landmark"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setPincode(rs.getInt("pincode"));
		address.setMobile(rs.getLong("phoneno"));
			resultList.add(address);
			
		}			
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (ps != null)
			try
			{
				ps.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		ConnectionPool.freeConnection(con);
	}


	return resultList;
	
}


	public void ChangePassword(String email,String newpassword){
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		try
		{
		  
		  ps = con.prepareStatement(UPDATE_PSW); 
		  ps.setString(1, newpassword);  
		  ps.setString(2, email);
		  int i=ps.executeUpdate();
		 
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(con);
		}
		
		
	}
	
	public void UpdateEmail(String email,String newemailid){
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		try
		{
		  
		  ps = con.prepareStatement(UPDATE_EMAIL);
		
		  ps.setString(1,newemailid);
		  ps.setString(2,email);
		  int i=ps.executeUpdate();
		 
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(con);
		}
		
		
	}
	public void deactivateAccount(String email,String password){
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		try
		{   
			 ps = con.prepareStatement(DEACTIVE);
			
			  ps.setString(1,email);
			  ps.setString(2,password);
			  int i=ps.executeUpdate();
			 	
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(con);
		}
	}

}
