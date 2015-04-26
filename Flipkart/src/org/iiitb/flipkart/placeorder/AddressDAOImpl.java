package org.iiitb.flipkart.placeorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.util.ConnectionPool;

public class AddressDAOImpl implements AddressDAO{
	private static String ADDRESS_EXISTS_QUERY="SELECT "
			+ "customername,pincode,address,landmark,phoneno "
			+ "FROM address"
			+ " where l_id=(SELECT login_id from login where l_mailid=?);";
	@Override
	public List<AddressVO> getAddressList(String Email) {
		List<AddressVO> list=new ArrayList<AddressVO>();
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps =null;
		try{
			ps=conn.prepareStatement(ADDRESS_EXISTS_QUERY);
			ps.setString(1, Email);
			AddressVO a=null;
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 a=new AddressVO();
				a.setCustomerName(rs.getString(1));
				a.setPinCode(rs.getInt(2));
				a.setAddress(rs.getString(3));
				a.setLandMark(rs.getString(4));
				a.setPhone(rs.getInt(5));
				list.add(a);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
