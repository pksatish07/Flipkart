package org.iiitb.flipkart.action.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.util.ConnectionPool;

public class ProductDAOImpl implements ProductDAO{

	private static String GET_ALL_LEVEL_2_CAT = "SELECT cat_name"
			+ " FROM flipkart.category"
			+ " WHERE"
			+ " cat_level = '2';";
	
	private static String INSERT_NEW_PRODUCT = "INSERT "
			+ "into flipkart.product(p_name,p_price,p_warranty_months,p_image,p_colour,p_deliverycharge,p_size,c_id) "
			+ " values"
			+ " (?,?,?,?,?,?,?,?);";
	
	
	public List<String> getAllLevel2Category() {
		
		List<String> categoryList = new ArrayList<String>();
		Connection conn = ConnectionPool.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(GET_ALL_LEVEL_2_CAT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				categoryList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return categoryList;
	}
	public boolean insertDetails(String productName, int productPrice,
			int warranty, FileInputStream inputStream, String color,
			int deliveryCharge, String productSize, String category) {
		
		int cat_id = 0;
		
		//System.out.println("input = "+inputStream+"name = "+productName);
		Connection conn = ConnectionPool.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select category_id from flipkart.category where cat_name = '"+category+"';");
			while(rs.next()){
				
				cat_id = rs.getInt(1);
			//	System.out.println("cat "+cat_id);
			}
		} catch (SQLException e1) {
			//System.out.println("error");
			e1.printStackTrace();
		}
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_NEW_PRODUCT);
			ps.setString(1,productName);
			ps.setInt(2,productPrice);
			ps.setInt(3,warranty);
			ps.setBlob(4,inputStream);
			ps.setString(5,color);
			ps.setInt(6,deliveryCharge);
			ps.setString(7,productSize);
			ps.setInt(8,cat_id);
			
			int a = ps.executeUpdate();
//			System.out.println("rows = "+a);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}

}
