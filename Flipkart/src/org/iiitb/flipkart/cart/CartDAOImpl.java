package org.iiitb.flipkart.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.iiitb.flipkart.common.ConnectionPool;

public class CartDAOImpl implements CartDAO{
public static final String FETCH_CART_ITEMS ="select p.p_name,p.p_price,p.p_warranty_months,p.p_colour,p.p_deliverycharge,p.p_size,seller.seller_name,seller.seller_id,c.p_quantity,p.product_id from product p,cart c,prod_sell s,seller seller where p.product_id=c.prod_id and p.product_id=s.p_id and s.s_id=seller.seller_id and c.lg_id=?";
public static final String CHANGE_CART_ITEMS =	"update cart set p_quantity=? where (lg_id=? and prod_id=?)";
public static final String REMOVE_CART_ITEMS =	"delete from cart where (lg_id=? and prod_id=?)";
//public static final String ADD_ITEMS_TO_CART = "insert into cart (prod_id,p_quantity,lg_id) values("+ "?"+")";
public static final String FETCH_CART_COUNT="select count(*) from cart where lg_id=?";
public static final String FETCH_CART_ID = "select prod_id from cart where lg_id= ?";
public static final String FETCH_PROD_FROM_ID ="select p.p_name,p.p_price,p.p_warranty_months,p.p_colour,p.p_deliverycharge,p.p_size,seller.seller_name,p.product_id from product p,prod_sell s,seller seller where p.product_id=s.p_id and s.s_id=seller.seller_id and p.product_id IN (?)";

@Override
	public List<CartVO> fetchCartItems(int loginId) {
		// TODO Auto-generated method stub
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs=null;
		CartVO voObj ;
		List<CartVO> resultList = new ArrayList<CartVO>();
		try
		{
			
			
			ps = con.prepareStatement( FETCH_CART_ITEMS);
			ps.setInt(1, loginId);
			rs = ps.executeQuery();
			while (rs.next())
			{
				voObj = new CartVO();
				voObj.setProductName(rs.getString(1));
				voObj.setPrice(rs.getInt(2));
				voObj.setWarrantyMonths(rs.getInt(3));
				voObj.setColour(rs.getString(4));
				voObj.setDeliveryCharge(rs.getInt(5));
				voObj.setSize(rs.getString(6));
				voObj.setSellerName(rs.getString(7));
				voObj.setSellerId(rs.getInt(8));
				voObj.setQuantatity(rs.getInt(9));
				voObj.setProductId(rs.getInt(10));
				resultList.add(voObj);
			}
		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
	
	
	@Override
	public void changeCartItems(int id, int qty , int loginId) {
		// TODO Auto-generated method stub
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		try
		{
			//new GradeInfo(term);
			
			ps = con.prepareStatement( CHANGE_CART_ITEMS);
			ps.setInt(1, qty);
			ps.setInt(2, loginId);
			ps.setInt(3, id);
			ps.executeUpdate();
		
		
			
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
		

		
	}


	@Override
	public void removeCartItems(int id, int loginId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		
		try
		{
			//new GradeInfo(term);
			
			ps = con.prepareStatement( REMOVE_CART_ITEMS);
			ps.setInt(1, loginId);
			ps.setInt(2, id);
		
			ps.executeUpdate();
		
		
			
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
		
		
	}


	@Override
	public void addCartItems(ArrayList<String> queryAssist,Map<String,String> pid,String loginId) {
		// TODO Auto-generated method stub
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs =null;
		//System.out.println("loginId "+loginId);
		ArrayList<String> updateList = new ArrayList<String>();
		
		try
		{
			
			ArrayList<String> tempList = new  ArrayList<String>(pid.keySet());
			
			ps = con.prepareStatement( "select prod_id,p_quantity from cart where lg_id="+loginId);
			rs = ps.executeQuery();
			int qty;
			//System.out.println(rs.getFetchSize());
			while(rs.next())
			{
				if(tempList.contains(rs.getString(1)))
				{
					
					//System.out.println("Entered");
					
					qty= rs.getInt(2)+Integer.parseInt(pid.get(rs.getString(1)));
					
					String temp;
					
					for(int i=0;i<queryAssist.size();i++)
					{
						temp = queryAssist.get(i);
						try
						{
							if(temp.split(",")[0].substring(1).contains(rs.getString(1))){
							updateList.add(rs.getString(1)+":"+qty);
							queryAssist.remove(i);
							}
						
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					
					}
					
				
				}
			}
			
			//System.out.println("outside while");
			
			StringBuffer formatString = new StringBuffer();
			int i = 0;
					for(String temp : queryAssist)
					{
						i++;
						formatString.append(temp);
						if(i!=queryAssist.size())
						formatString.append(",");
						
					}
					
			//System.out.println("test "+queryAssist);
			//System.out.println("test 1 "+formatString.toString());
			
			
			if (formatString.toString() != ""
					&& formatString.toString().length() >= 5) {
				ps = con.prepareStatement("insert into cart (prod_id,p_quantity,lg_id) values"
						+ formatString.toString());

				ps.executeUpdate();
			}
			
			
			//System.out.println("test 2 "+updateList);
			
			
			String id;
			String quantity;
			for(String temp : updateList)
			{
				
				id = temp.split(":")[0];
				quantity = temp.split(":")[1];
				
				ps = con.prepareStatement( "update cart set p_quantity="+quantity+" where prod_id="+id+" AND lg_id="+loginId);
				
				
				
				ps.executeUpdate();
				
			}
			
			
		
			
		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
		
		
		
	}


	@Override
	public int fetchCartCount(String loginId) {
		// TODO Auto-generated method stub
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0 ;
		try
		{
			//new GradeInfo(term);
			
			ps = con.prepareStatement( FETCH_CART_COUNT);
			ps.setString(1,loginId);
			
		
			rs = ps.executeQuery();
			while (rs.next())
			{
				count =rs.getInt(1);
			}
		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
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
		
		return count ;
	}


	@Override
	public List<String> fetchCartId(String loginId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<String> idList = new ArrayList<String>();
		try
		{
			//new GradeInfo(term);
			
			ps = con.prepareStatement( FETCH_CART_ID);
			ps.setString(1,loginId);
			
		
			rs = ps.executeQuery();
			while (rs.next())
			{
				idList.add(rs.getString(1));
			}
		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
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
		
		return idList ;
	}


	@Override
	public ArrayList<CartVO> getProdDetailsFromId(String queryAssist,
			Map<String, String> qtyMap) {
		// TODO Auto-generated method stub
		
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs=null;
		CartVO voObj ;
		List<CartVO> resultList = new ArrayList<CartVO>();
		try
		{
			
			
			ps = con.prepareStatement("select p.p_name,p.p_price,p.p_warranty_months,p.p_colour,p.p_deliverycharge,p.p_size,seller.seller_name,p.product_id from product p,prod_sell s,seller seller where p.product_id=s.p_id and s.s_id=seller.seller_id and p.product_id IN ("+queryAssist+")");
			//ps.setString(1, queryAssist);
			rs = ps.executeQuery();
			while (rs.next())
			{
				
				voObj = new CartVO();
				voObj.setProductName(rs.getString(1));
				voObj.setPrice(rs.getInt(2));
				voObj.setWarrantyMonths(rs.getInt(3));
				voObj.setColour(rs.getString(4));
				voObj.setDeliveryCharge(rs.getInt(5));
				voObj.setSize(rs.getString(6));
				voObj.setSellerName(rs.getString(7));
				voObj.setQuantatity((Integer.parseInt(qtyMap.get(String.valueOf(rs.getInt(8))))));
				voObj.setProductId(rs.getInt(8));
				resultList.add(voObj);
			}
		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
		
		
		return (ArrayList<CartVO>)resultList;

		
	}
	
	
}
	
