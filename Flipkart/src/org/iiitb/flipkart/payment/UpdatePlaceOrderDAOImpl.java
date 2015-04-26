package org.iiitb.flipkart.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.flipkart.login.User;

import com.opensymphony.xwork2.ActionContext;

public class UpdatePlaceOrderDAOImpl implements UpdatePlaceOrderDAO,SessionAware{

	private SessionMap<String, Object> session;

	private static final String CART_DETAILS = "select * from cart where lg_id=?;";
	private static final String DELETE_CART_DETAILS = "DELETE FROM cart WHERE cart_id=?;";
	private static final String UPDATEPLACEORDER = "INSERT INTO placeorder (`pstatus`, `a_id`, `lgid`, `sell_id`, `prod_id`, `p_quantity`) VALUES (?, ?, ?, ?, ?, ?);";
	
	List<Integer> card_ids;
	HashMap<Integer,Integer> prdordered ;
	
	//get login id from session
	
	int lg_id;
	//int a_id=1;
	//int sell_id=1;
	//int prod_id=1;
	//int p_quantity=1;
	String pstatus = "waiting"; 
	

	@Override
	public String updatePlaceOrder(int addressId) {
		
		
		/**/
		
		System.out.println("Testing testing"+ActionContext.getContext().getSession().get("User"));
		
		User u = (User)ActionContext.getContext().getSession().get("User");
		lg_id = u.getLoginId();
		System.out.println("login_id:"+lg_id);
		
		
		card_ids = new ArrayList<Integer>();
		prdordered = new HashMap<Integer,Integer>(); 
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement ps = null;
		ResultSet rs;
		
		
		try {
			
			ps = conn.prepareStatement(CART_DETAILS);
			ps.setInt(1,lg_id);
			rs = ps.executeQuery();
			while(rs.next()){
				
				card_ids.add(rs.getInt("cart_id"));
				prdordered.put(rs.getInt("prod_id"),rs.getInt("p_quantity"));
				
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
		
		deletecartdetails();
		addToPlaceOrder(addressId);


		return "success";
	}
	
	public void deletecartdetails(){
		
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement ps = null;
		
		
		try {
			
			ps = conn.prepareStatement(DELETE_CART_DETAILS);
			
			for(Integer ca_id : card_ids){
				
				ps.setInt(1,ca_id);
				ps.executeUpdate();
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
		
	}
	
	
	public void addToPlaceOrder(int a_id){
		
		HashMap<Integer,Integer> pid_seller = (HashMap<Integer,Integer>)ActionContext.getContext().getSession().get("prodselldetails");
		System.out.println("pid_seller:"+ActionContext.getContext().getSession().get("prodselldetails"));
		int prod_id;
		int sell_id;
		int p_quantity;
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement ps = null;
		
		
		try {
			
			ps = conn.prepareStatement(UPDATEPLACEORDER);
			
			for(Map.Entry<Integer, Integer> e:prdordered.entrySet()){
				
				prod_id = e.getKey();
				p_quantity = e.getValue();
				//get seller id for that particular product
				sell_id = pid_seller.get(prod_id);
				
				ps.setString(1,pstatus);
				ps.setInt(2,a_id);
				ps.setInt(3,lg_id);
				ps.setInt(4,sell_id);
				ps.setInt(5,prod_id);
				ps.setInt(6,p_quantity);
				
				ps.executeUpdate();
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
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap<String, Object>) session;
	}

}
