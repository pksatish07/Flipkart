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
			+ "into flipkart.product(p_name,p_price,p_warranty_months,p_image,p_colour,p_deliverycharge,p_size,c_id,d_id) "
			+ " values"
			+ " (?,?,?,?,?,?,?,?,?);";
	
	private static String INSERT_NEW_DESCRIPTION = "INSERT "
			+ "into flipkart.description(description,specification,keyfeatures) "
			+ " values"
			+ " (?,?,?);";
	
	private static String SELECT_MAX_ID="SELECT MAX(description_id) FROM flipkart.description;";
	
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
			int deliveryCharge, String productSize, String category,String description,String specs,String kf) {
		
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
			PreparedStatement ps = conn.prepareStatement(INSERT_NEW_DESCRIPTION);
			ps.setString(1,description);
			ps.setString(2,specs.replace("\n", "|"));
			ps.setString(3,kf.replace("\n", "|"));
			int a = ps.executeUpdate();
			
			int d_id = -1;
			
			ResultSet result = conn.createStatement().executeQuery(SELECT_MAX_ID);
			
			while(result.next())
			{
				d_id = result.getInt(1);
			}
			
			PreparedStatement ps1 = conn.prepareStatement(INSERT_NEW_PRODUCT);
			ps1.setString(1,productName);
			ps1.setInt(2,productPrice);
			ps1.setInt(3,warranty);
			ps1.setBlob(4,inputStream);
			ps1.setString(5,color);
			ps1.setInt(6,deliveryCharge);
			ps1.setString(7,productSize);
			ps1.setInt(8,cat_id);
			ps1.setInt(9, d_id);
			
			int b = ps1.executeUpdate();
//			System.out.println("rows = "+a);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return true;
	}

}
