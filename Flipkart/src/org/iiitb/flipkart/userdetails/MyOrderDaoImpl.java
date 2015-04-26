package org.iiitb.flipkart.userdetails;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.iiitb.flipkart.userdetails.AddressInfo;
import org.iiitb.flipkart.userdetails.MyOrderInfo;
import com.flipkart.util.ConnectionPool;

public class MyOrderDaoImpl implements MyOrderDao{
private List<MyOrderInfo> resultList = new ArrayList<MyOrderInfo>();
	
	private static final String MYORDERS="select pl.placeorder_id,p.product_id,p.p_name,p.p_price,p.p_colour,p.p_size,pl.p_quantity,pl.pstatus,s.seller_name"
			+ " from placeorder pl,product p,seller s"
			+ " where (pl.prod_id=p.product_id AND pl.sell_id=s.seller_id AND pl.lgid=?);";
	
	private static final String ORDERIMAGE="select p_image from product where product_id=?;";
	public List<MyOrderInfo> getmyorders(int emailid)
	{     
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		MyOrderInfo order;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement(MYORDERS);
			ps.setInt(1, emailid);
			rs = ps.executeQuery();
			while (rs.next())
			{       order= new MyOrderInfo();
				   order.setPname(rs.getString("p_name"));
				   order.setPrice(rs.getInt("p_price"));
				   order.setOrderid(rs.getInt("placeorder_id"));
				   order.setProductId(rs.getInt("product_id"));
				   order.setPcolor(rs.getString("p_colour"));
				   order.setPsize(rs.getString("p_size"));
				   order.setPquantity(rs.getInt("p_quantity"));
				   order.setPstatus(rs.getString("pstatus"));
				   order.setPseller(rs.getString("seller_name"));
				 
				 	resultList.add(order);
				
			}			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			ConnectionPool.freeConnection(con);
		}

		
		return resultList;
	}
    
	
	public MyOrderInfo getproductimage(int productID){
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		MyOrderInfo order = null;
		ResultSet rs;
		try
		{    order= new MyOrderInfo();
			ps = con.prepareStatement(ORDERIMAGE);
			ps.setInt(1,productID);
			rs = ps.executeQuery();

			if (rs.next())
			{
				 order.setPhoto(rs.getBinaryStream("p_image"));
			}		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			ConnectionPool.freeConnection(con);
		}

		
		return order;
	}
}
