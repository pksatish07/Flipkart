package org.iiitb.flipkart.stock;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.util.ConnectionPool;

public class NotifyMeDAOImpl implements NotifyMeDAO{

	private static final String INSERT_NOTIFICATION_REQ="insert into stock_notification(p_id,email_id) values (?,?);";
	private static final String NULL = null; 
	private static final String GET_PERSON_LIST_NOTIFY="select email_id from stock_notification where p_id=?;";
	public String notifyRequest(int p_id,String email_id)
	{
		Connection conn = ConnectionPool.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_NOTIFICATION_REQ);
			ps.setInt(1, p_id);
			ps.setString(2,email_id);
			int a = ps.executeUpdate();
			
			if(a==0)
				return NULL;
			
				else 
					return "success";
			
						
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "success";
	}
	
	public List<String> getPersonsWhoReqForProduct(int p_id)
	{
		ArrayList<String> person_list=new ArrayList<String>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
				ps =  conn.prepareStatement(GET_PERSON_LIST_NOTIFY);
				ps.setInt(1,p_id);
				ResultSet rs = ps.executeQuery();
			
				while(rs.next()){
					person_list.add(rs.getString(1));
				}
				
			}
		catch (SQLException e) {
			
			e.printStackTrace();
			}
		return person_list;
	}
}
