package org.iiitb.flipkart.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



public class PaymentDaoImpl implements PaymentDao{

	@Override
	public CreditCardDetails c_pay(PayAction details) {
		// TODO Auto-generated method stub
		
		
		CreditCardDetails newcard = new CreditCardDetails();
		
		Connection conn = ConnectionPool.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs;
		String query ="select * from creditcard where c_card_no="+details.getCardNumber()+";";
		try {
			ps = conn.prepareStatement(query);
			//ps.setLong(1, details.getCardNumber());
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("nameoncard"));
				newcard.setcCardNo(rs.getLong("c_card_no"));
				newcard.setCvv(rs.getInt("cvv"));
				newcard.setExpDate(rs.getString("expdate"));
				newcard.setNameOnCard(rs.getString("nameoncard"));
				newcard.setLimit(rs.getInt("limit"));
				newcard.setAvailbalance(rs.getInt("available_bal"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionPool.freeConnection(conn);
		}
		return newcard;
	}

	public void transferAmt(CreditCardDetails cd,HashMap<Integer,Integer> orderscost) {
		int s_balance=0;
		String query2;
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs;
		String query = "update creditcard set available_bal = "+cd.getAvailbalance()+" where c_card_no= "+cd.getcCardNo()+"; ";
		try {
			stmt = conn.prepareStatement(query);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(Map.Entry<Integer,Integer> ocost : orderscost.entrySet()){
			System.out.println(ocost.getKey() +" :: "+ ocost.getValue());
			
			int seller_id = ocost.getKey();
			query = "select balance from account where account_id = (select seller_account_id from seller where seller_id = "+seller_id+");";
			try {
				stmt = conn.prepareStatement(query);
				rs = stmt.executeQuery();
				while(rs.next()){
					s_balance = rs.getInt("balance");
					
				}
				
				query2 = "update account set balance = "+ (s_balance + ocost.getValue())+" where account_id = (select seller_account_id from seller where seller_id = "+seller_id+");";
				stmt = conn.prepareStatement(query2);
				stmt.executeUpdate();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            
        }	
	}

}
