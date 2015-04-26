package org.iiitb.flipkart.stock;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.LinkedHashMap;
import com.flipkart.util.ConnectionPool;


public class SellerDAOImpl implements SellerDAO {

	private static final String GET_SELLER = "select seller_id,seller_name from flipkart.seller;";
	
	public Map<String,String> getSellerList()
	{ 
		Map<String,String> sellerList = new LinkedHashMap<String,String>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
			ps =  conn.prepareStatement( GET_SELLER);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("Name "+rs.getString(1));
				System.out.println("NAme +"+rs.getString(2));
				sellerList.put(rs.getString(1),rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return sellerList;
	}
		
		
	}


