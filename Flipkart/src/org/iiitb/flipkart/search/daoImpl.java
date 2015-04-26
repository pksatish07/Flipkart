package org.iiitb.flipkart.search;
import org.iiitb.flipkart.common.*;

import com.flipkart.util.ConnectionPool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class daoImpl implements dao{
	
	public List<String> getNames() {
		
	List<String> products = new ArrayList<String>();	
	Connection connection = ConnectionPool.getConnection();
	Statement stmt = null;
	
	
	try {
	
	
	stmt = connection.createStatement();
	String query2 = "select p_name from product;";
	String query1 = "select cat_name from category where cat_level=1 or cat_level=2;";
	ResultSet rs = stmt.executeQuery(query2);
	while(rs.next()){
		products.add(rs.getString(1));
	}
	rs = stmt.executeQuery(query1);
	while(rs.next()){
		products.add(rs.getString(1));
	}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		
		ConnectionPool.freeConnection(connection);
	}
	return products;

}

	@Override
	public int getStatus(String product) {
		int status = 0;
		Statement stmt = null;
		Connection connection = ConnectionPool.getConnection();
		
		try {
				
		stmt = connection.createStatement();
		String query1 = "select cat_level from category where cat_name ='"+product+"'";
		ResultSet rs = stmt.executeQuery(query1);
		if(rs.next())
		{
			status = rs.getInt(1);
			
		}
		else
		{
			status = 3;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return status;
	}

	@Override
	public List<ProductInfo> getLevel2(String product) {
		List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		
		try {
			
		
		stmt = connection.createStatement();
		String query1 = "SELECT product_id,p_name,p_price,stock from product p, category c where cat_name = '"+product+"' and c_id = category_id";
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_price = rs.getString(3);
			int stockCount = rs.getInt(4);
			ProductInfo productDetail = new ProductInfo(id,p_name,p_price,stockCount);
			productInfo.add(productDetail);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return productInfo;
	}

	@Override
	public List<ProductInfo> getLevel1(String product) {
List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		
		try {
			
		
		stmt = connection.createStatement();
		String query1 = "select product_id,p_name,p_price,stock from category c,product p where c.cat_parent = (select category_id from category where cat_name='"+product+"') and c.category_id= p.c_id;";
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_price = rs.getString(3);
			int stockCount = rs.getInt(4);
			ProductInfo productDetail = new ProductInfo(id,p_name,p_price,stockCount);
			productInfo.add(productDetail);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return productInfo;
		
	}

	@Override
	public ProductImage getImage(int productId) {
		
		ProductImage image = new ProductImage();
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
			String query1 = "select p_image from product where product_id ="+productId+";";
			ResultSet rs = stmt.executeQuery(query1);
			if (rs.next())
			{
				InputStream binaryStream = rs.getBinaryStream(1);
				image.setPhoto(binaryStream);
			}
			
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return image;
	}

	@Override
	public List<ProductInfo> getLevel0(String product) {
		List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/flipkart","root","root");
		
		stmt = connection.createStatement();
		String query1 = "select product_id,p_name,p_price,stock from product where p_name = '"+product+"'";
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_price = rs.getString(3);
			int stockCount = rs.getInt(4);
			ProductInfo productDetail = new ProductInfo(id,p_name,p_price,stockCount);
			productInfo.add(productDetail);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return productInfo;
	}
	@Override
	public List<ProductInfo> getLevel0(String product,int low,int high) {
		List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/flipkart","root","root");
		
		stmt = connection.createStatement();
		String query1 = "select product_id,p_name,p_price,stock from product where p_name = '"+product+"' and p_price>="+low+" and p_price<="+high+";";
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_price = rs.getString(3);
			int stockCount = rs.getInt(4);
			ProductInfo productDetail = new ProductInfo(id,p_name,p_price,stockCount);
			productInfo.add(productDetail);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return productInfo;
	}

	@Override
	public List<ProductInfo> getLevel2(String product, int low,int high) {
		// TODO Auto-generated method stub
List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		
		try {
			
		
		stmt = connection.createStatement();
		String query1 = "SELECT product_id,p_name,p_price,stock from product p, category c where cat_name = '"+product+"' and c_id = category_id and p.p_price>="+low+" and p.p_price<="+high+";";
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_price = rs.getString(3);
			int stockCount = rs.getInt(4);
			ProductInfo productDetail = new ProductInfo(id,p_name,p_price,stockCount);
			productInfo.add(productDetail);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return productInfo;
	}

	@Override
	public List<ProductInfo> getLevel1(String product, int low,int high) {
		// TODO Auto-generated method stub
List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		
		Connection connection = ConnectionPool.getConnection();
		Statement stmt = null;
		
		try {
			
		
		stmt = connection.createStatement();
		String query1 = "select product_id,p_name,p_price,stock from category c,product p where c.cat_parent = (select category_id from category where cat_name='"+product+"') and c.category_id= p.c_id and p.p_price>="+low+" and p.p_price<="+high+";";
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String p_name = rs.getString(2);
			String p_price = rs.getString(3);
			int stockCount = rs.getInt(4);
			ProductInfo productDetail = new ProductInfo(id,p_name,p_price,stockCount);
			productInfo.add(productDetail);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionPool.freeConnection(connection);
		}
		return productInfo;
	}

@Override
	public ArrayList<String> getFrameWork(String term) {
		// TODO Auto-generated method stub
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/flipkart","root","root");
		 
		Connection connection = ConnectionPool.getConnection();
		ArrayList<String> list = new ArrayList<String>();
		Statement stmt = null;
		String data;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT p_name FROM product  WHERE p_name LIKE '"+term+"%'");
			while (rs.next()) {
				data = rs.getString(1);
				list.add(data);
			}
			rs = stmt.executeQuery("SELECT cat_name FROM category WHERE cat_name LIKE '"+term+"%' and (cat_level=1 or cat_level=2) ");
			while (rs.next()) {
				data = rs.getString(1);
				list.add(data);
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
		
	}

}
