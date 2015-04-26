package org.flipkart.accountinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements AccountDao{

	@Override
	public String AccountInfo(Connection con, String AccNo) {
		PreparedStatement ps = null;
		String amount="";
		try {
			ps = con.prepareStatement("select balance from account where account_no = ?");
			ps.setString(1,AccNo);
			ResultSet result = ps.executeQuery();
			
			if (result.next())
			{
				amount=String.valueOf(result.getString(1));				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return amount;
	}

	@Override
	public String CreditInfo(Connection con, String CreditNo) {
		PreparedStatement ps = null;
		String amount="";
		try {
			System.out.println(CreditNo);
			ps = con.prepareStatement("select available_bal from creditcard where c_card_no=?");
			ps.setString(1,CreditNo);
			ResultSet result = ps.executeQuery();
			
			if (result.next())
			{
				amount=String.valueOf(result.getString(1));				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return amount;
	}

}
