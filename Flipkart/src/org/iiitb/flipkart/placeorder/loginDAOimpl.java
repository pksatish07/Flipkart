package org.iiitb.flipkart.placeorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAOimpl implements loginDAO {
	String GETPASSWORD="SELECT l_password FROM login where l_mailid=?;";
	String GETMAIL="select l_mailid from login where l_mailid=?;";
	String GETUSERTYPE="SELECT l_type FROM login where l_mailid=?;";
	String ADDUSERQUERY="INSERT into login(l_type,l_mailid,l_password) values(?,?,?);";
	String AddressExistsQuery="SELECT customername,pincode,address,landmark,phoneno FROM address where l_id=?;";
	@Override
	public boolean CheckUserMailId(Connection con, String Email,String password) {
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(GETMAIL);
			ps.setString(1,Email);
			ResultSet result = ps.executeQuery();
			ResultSet rs;
			if (result.next())
			{
				
				ps = con.prepareStatement(GETPASSWORD);
				ps.setString(1,Email);
				rs=ps.executeQuery();
				if(rs.next()){
					String pass=rs.getString(1);
					if(password.equals(pass))
					{
						
						return true;
					}
					else
					{
						
						return false;
					}
				}
				else{
					return false;
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	public boolean AddUser(Connection con,String Email,String password)
	{
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(ADDUSERQUERY);
			ps.setString(1,"N");
			ps.setString(2, Email);
			ps.setString(3, password);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	
	
	
	
public boolean CheckUserMailId(Connection con, String Email) {
	
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(GETMAIL);
			ps.setString(1,Email);
			ResultSet result = ps.executeQuery();
			if (result.next())
			{
				
				return true;
				
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	
	
	
	@Override
	public String getUserType(String mailID, Connection con) {
		PreparedStatement ps = null;
		String userType="";
		try {
			ps = con.prepareStatement(GETUSERTYPE);
			ps.setString(1,mailID);
			ResultSet result = ps.executeQuery();
			
			if (result.next())
			{
				userType=result.getString(1);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return userType;
	}
	
	public String AddressExists(Connection con,String Email)
	{
		
		return "yes";
	}
	

}
