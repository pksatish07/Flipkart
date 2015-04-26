package org.iiitb.flipkart.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.flipkart.util.ConnectionPool;

public class CheckStockDAOImpl implements CheckStockDAO{

	private static final String GET_PROD_LIST_BY_CAT="select product_id,p_name,p_price,stock from flipkart.product where stock<5 "
			+ "and product_id in (select product_id from flipkart.product where c_id"
			+ " in (select category_id from flipkart.category where"
			+ " cat_parent=?));";
	
	private static final String GET_CATEGORY_BY_LEVEL = "select category_id,cat_name from flipkart.category"
			+ " WHERE"
			+ " cat_level = ?;"; 
	
	private static final String GET_PROD_LIST_BY_SELLER= "select product_id,p_name,p_price,stock from flipkart.product "
			+ "where "
			+ "stock<5"
			+ " and "
			+ "product_id in (select p_id from flipkart.prod_sell where s_id=?)";
	
	private static final String GET_SELLER = "select seller_id,seller_name from flipkart.seller;";
	
	public ArrayList<ProductValueObject> getProductListOfLowStockByCategory(String cat_id)
	{
		ArrayList<ProductValueObject> productlistoflowstock=new ArrayList<ProductValueObject>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
			ps =  conn.prepareStatement(GET_PROD_LIST_BY_CAT);
			ps.setInt(1,Integer.parseInt(cat_id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ProductValueObject obj=new ProductValueObject();
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println();
				obj.setProduct_id(rs.getString(1));
				obj.setP_name(rs.getString(2));
				obj.setP_price(rs.getString(3));
				obj.setStock(Integer.parseInt(rs.getString(4)));
				productlistoflowstock.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	
		return productlistoflowstock;
	}

	
	
	@Override
	public Map<String,String> getCategoryList(String categoryLevel) {
		
		Map<String,String> categoryList=new LinkedHashMap<String,String>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
			ps =  conn.prepareStatement(GET_CATEGORY_BY_LEVEL);
			ps.setInt(1,Integer.parseInt(categoryLevel));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("Name"+rs.getString(1));
				categoryList.put(rs.getString(1),rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return categoryList;
	}
	

	
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
	
	
	public ArrayList<ProductValueObject> getProductListOfLowStockBySeller(String seller_id)
	{
		ArrayList<ProductValueObject> productlistoflowstock=new ArrayList<ProductValueObject>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
			ps =  conn.prepareStatement(GET_PROD_LIST_BY_SELLER);
			ps.setInt(1,Integer.parseInt(seller_id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ProductValueObject obj=new ProductValueObject();
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println();
				obj.setProduct_id(rs.getString(1));
				obj.setP_name(rs.getString(2));
				obj.setP_price(rs.getString(3));
				obj.setStock(Integer.parseInt(rs.getString(4)));
				productlistoflowstock.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	
		return productlistoflowstock;
	}
}
