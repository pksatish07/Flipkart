package org.iiitb.flipkart.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAOimpl implements loginDAO {
	String GETPASSWORD="SELECT l_password FROM login where l_mailid=?;";
	String GETMAIL="select l_mailid from login where l_mailid=?;";
	String GETUSERTYPE="SELECT l_type FROM login where l_mailid=?;";
	String SIGNUPNEWUSER="INSERT INTO login (l_mailid,l_type,l_password) VALUES (?,?,?);";
	String GETUSER="select * from login where l_mailid=?";
	String CHECKVALIDMAIL="select l_mailid from login where l_mailid=?;";
	String RESETPASSWORD="UPDATE login SET l_password=? WHERE l_mailid=?; ";
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
					System.out.println(pass+password);
					if(password.equals(pass))
					{
						System.out.println(pass);
						return true;
					}
					else
					{
						//System.out.println(pass);
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
	@Override
	public boolean signUpNewUser(Connection connection, String signupId,
			String signUpPassId,String UserType) {
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(SIGNUPNEWUSER);
			ps.setString(1,signupId);
			ps.setString(2,UserType);
			ps.setString(3,signUpPassId);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public User getUser(Connection connection,String mailID) {
PreparedStatement ps = null;
User user=new User();
		try {
			
			ps = connection.prepareStatement(GETUSER);
			ps.setString(1,mailID);
			
			ResultSet rs=ps.executeQuery();
			if (rs.next())
			{
			user.setFirstName(rs.getString("l_firstname"));	
			user.setLastName(rs.getString("l_lastname"));
			user.setMobileNo(rs.getLong("l_mobileno"));
			user.setLandLine(rs.getString("landline"));
			user.setLoginId(rs.getInt("login_id"));
			user.setGender(rs.getString("gender"));
			user.setPassword(rs.getString("l_password"));
			user.setMailId(rs.getString("l_mailid"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return user;
	}
	@Override
	public boolean checkValid(Connection connection, String mailId) {
		PreparedStatement ps = null;
		User user=new User();
				try {
					
					ps = connection.prepareStatement(CHECKVALIDMAIL);
					ps.setString(1,mailId);
					
					ResultSet rs=ps.executeQuery();
					if (rs.next())
					{
					return true;
					}
					else
					{
						return false;
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
		
		return false;
	}
	@Override
	public void resetPassword(Connection connection, String forgotMailId,
			String newPasssword) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(RESETPASSWORD);
			ps.setString(1,newPasssword);
			ps.setString(2,forgotMailId);
		
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
		
}
