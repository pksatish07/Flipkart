/**
 * 
 */
package com.flipkart.daoimpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.flipkart.dao.ProductDAO;
import com.flipkart.products.ProductInfo;



public class ProductDAOImpl implements ProductDAO {

	private static final String GET_PRODUCT_DETAILS = "SELECT PRODUCT_ID, P_NAME, P_PRICE, p_warranty_months, p_colour, p_deliverycharge, p_size,stock, description, specification, keyfeatures FROM product, description  where product_id = ? AND product.d_id = description.description_id";

	private static final String GET_PRODUCT_DETAILS_BY_NAME = "SELECT PRODUCT_ID, P_NAME, P_PRICE, p_warranty_months, p_colour, p_deliverycharge, p_size,stock, description, specification, keyfeatures FROM product, description  where p_name = ? AND product.d_id = description.description_id";

	private static final String GET_PRODUCT_IMAGE = "SELECT p_image FROM product where product_id = ? ";
	
	private static final String GET_PRODUCT_IMAGE_BY_NAME = "SELECT p_image FROM product where p_name = ? ";

	
	@Override
	public ProductInfo getProduct(Connection connection, int productId) {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = null;
		ResultSet rs;
		
		ProductInfo productInfo = null;
		try {
			ps = connection.prepareStatement(GET_PRODUCT_DETAILS);
			
			ps.setInt(1, productId);
			
			rs = ps.executeQuery();
			rs.next();
			productInfo = new ProductInfo(rs.getInt("product_id"),rs.getString("p_name"),rs.getInt("p_price"), rs.getInt("p_warranty_months"),
					                      rs.getString("p_colour"),rs.getInt("p_deliverycharge"),rs.getString("p_size"),
					                      rs.getString("description"), rs.getString("keyfeatures"),rs.getString("specification"),rs.getInt("stock"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}

		return productInfo;
	}
	
	public OutputStream getProductPhoto(Connection connection, int productId)
	{
		
		   
		    ProductInfo product = null;
			PreparedStatement ps = null;
			ResultSet rs;
		    try {
				ps = connection.prepareStatement(GET_PRODUCT_IMAGE);
				
				ps.setInt(1, productId);
				
				rs = ps.executeQuery();
				rs.next();
				product = new ProductInfo(productId,rs.getBinaryStream("p_image"));
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		    HttpServletResponse response = ServletActionContext.getResponse();
		    response.setContentType("image/jpeg");
		    InputStream in = product.getPhoto();
		    OutputStream out = null;
			try {
				out = response.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    byte[] buffer = new byte[1024];
		    int len;
		    try {
				while ((len = in.read(buffer)) != -1) {
				  out.write(buffer, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
		return out;
	}

	@Override
	public ProductInfo getProduct(Connection connection, String productName) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs;
		
		ProductInfo productInfo = null;
		try {
			ps = connection.prepareStatement(GET_PRODUCT_DETAILS_BY_NAME);
			
			ps.setString(1, productName);
			
			rs = ps.executeQuery();
			rs.next();
			productInfo = new ProductInfo(rs.getInt("product_id"),rs.getString("p_name"),rs.getInt("p_price"), rs.getInt("p_warranty_months"),
					                      rs.getString("p_colour"),rs.getInt("p_deliverycharge"),rs.getString("p_size"),
					                      rs.getString("description"), rs.getString("keyfeatures"),rs.getString("specification"),rs.getInt("stock"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}

		return productInfo;
	}
	
	public OutputStream getProductPhoto(Connection connection, String productName)
	{
		
		   
		    ProductInfo product = null;
			PreparedStatement ps = null;
			ResultSet rs;
		    try {
				ps = connection.prepareStatement(GET_PRODUCT_IMAGE_BY_NAME);
				
				ps.setString(1, productName);
				
				rs = ps.executeQuery();
				rs.next();
				product = new ProductInfo(productName,rs.getBinaryStream("p_image"));
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		    HttpServletResponse response = ServletActionContext.getResponse();
		    response.setContentType("image/jpeg");
		    InputStream in = product.getPhoto();
		    OutputStream out = null;
			try {
				out = response.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    byte[] buffer = new byte[1024];
		    int len;
		    try {
				while ((len = in.read(buffer)) != -1) {
				  out.write(buffer, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
		return out;
	}
	
}