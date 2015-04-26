package org.iiitb.flipkart.action.category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;

import com.flipkart.util.*;

public  class CategoryDAOImpl implements CategoryDAO{

	private static final String GET_CATEGORY_BY_LEVEL = "select cat_name from flipkart.category"
			+ " WHERE"
			+ " cat_level = ?;"; 
	
	private static final String ADD_NEW_CATEGORY_TO_NOTIFY = "insert into flipkart.category_notification"
			+ " (cat_name,cat_level,cat_description,cat_parent,adder_adminid)"
			+ " values (?,?,?,?,?);";
	
	private static final String ADD_NEW_CATEGORY = "insert into flipkart.category(cat_name,cat_level,cat_description,cat_parent) "
			+ " values(?,?,?,?);";
	
	private static final String GET_CATEGORY_NOTIFY_DETAILS ="SELECT "
			+ "category_notificationid,cat_name,cat_level,cat_description,cat_parent,l_firstname,l_lastname"
			+ " FROM flipkart.category_notification c ,flipkart.login l "
			+ " where c.adder_adminid = l.login_id;";
	
	private static final String GET_CATEGORY_BY_LEVEL1 = "select category_id,cat_name from flipkart.category"
			+ " WHERE"
			+ " cat_level = ?;"; 
	
	private static final String GET_SELLER = "select seller_id,seller_name from flipkart.seller;";
	
	@Override
	
	
	public List<String> getCategoryNames(String categoryLevel) {
		
		List<String> categoryNames = new ArrayList<String>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		ResultSet rs = null;
		try {
			ps =  conn.prepareStatement(GET_CATEGORY_BY_LEVEL);
			ps.setInt(1,Integer.parseInt(categoryLevel)-1);
			rs = ps.executeQuery();
			
			while(rs.next()){
				categoryNames.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return categoryNames;
	}
	
	
	@Override
	public boolean addNewCategory(String categoryName, String description,
			String categoryLevel, String parentName) {
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		String query = "select category_id from flipkart.category where cat_name = '"+parentName+"'";
		int cat_id = 0;
		try {
			ps=conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				cat_id = rs.getInt(1);
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			return false;
		}
		
		try {
			ps = conn.prepareStatement(ADD_NEW_CATEGORY);
			ps.setString(1,categoryName);
			ps.setString(2,categoryLevel);
			ps.setString(3, description);
			ps.setInt(4,cat_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addToNotifyCategory(String categoryName, String description,
			String categoryLevel, String parentName,int admin_id) {
	
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
			ps=conn.prepareStatement(ADD_NEW_CATEGORY_TO_NOTIFY );
			ps.setString(1, categoryName);
			ps.setString(2, categoryLevel);
			ps.setString(3, description);
			ps.setString(4, parentName);
			ps.setInt(5,admin_id);
			
			ps.executeUpdate();

		} catch (SQLException e1) {
			
			e1.printStackTrace();
			return false;
		}
		
		return true;
	}


	@Override
	public List<CategoryDetails> getApproveCategoryList() {
		
		List<CategoryDetails> list = new ArrayList<CategoryDetails>();
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
		
			ps=conn.prepareStatement(GET_CATEGORY_NOTIFY_DETAILS);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				CategoryDetails temp = new CategoryDetails();
				temp.setNotificationId(rs.getInt(1));
				temp.setCategoryName(rs.getString(2));
				temp.setCategoryLevel(rs.getInt(3));
				temp.setDescription(rs.getString(4));
				temp.setParentName(rs.getString(5));
				temp.setAdmin_fname(rs.getString(6));
				temp.setAdmin_lname(rs.getString(7));
				
				list.add(temp);
				
			}

		}catch(SQLException e1) {
			
			e1.printStackTrace();
			return null;
		}
		
		return list;
	}


	@Override
	public boolean addThisCategory(int notificationId) {
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		PreparedStatement ps2 =  null;
		//System.out.println("inside dao id = "+notificationId);
		String catName = "",catDescription="";
		int catLevel = 0,parentId=0;
		ResultSet rs =  null;
		String parent_name = "";
		String sqlQuery = "select "
				+ " cn.cat_name,cn.cat_level,cn.cat_description,c.category_id "
				+ " from flipkart.category_notification cn,flipkart.category c "
				+ " where cn.category_notificationid ="+notificationId+""
				+ " and c.category_id = (select category_id from flipkart.category"
				+ " where cat_name = "
				+ "(select cat_parent from flipkart.category_notification where category_notificationid ="+notificationId+"));";
		
		String deleteQuery = "delete from flipkart.category_notification where category_notificationid ="+notificationId+";";
		
		try {
			ps = conn.prepareStatement("select cat_parent from flipkart.category_notification where "
					+ "category_notificationid = "+notificationId+";");
			
			ResultSet rs2 = ps.executeQuery();
			
			while(rs2.next()){
				
				parent_name = rs2.getString(1);
				//System.out.println("parent name = "+parent_name);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		if(parent_name.equals("no parent")){
			
			
			sqlQuery = "select "
				+ " cn.cat_name,cn.cat_level,cn.cat_description "
				+ " from flipkart.category_notification cn "
				+ " where cn.category_notificationid ="+notificationId+";";
		}
		try {
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				catName = rs.getString(1);
//				System.out.println("catName = "+catName);
				catLevel = rs.getInt(2);
	//			System.out.println("catlevel = "+catLevel);
				catDescription = rs.getString(3);
		//		System.out.println("catdesc = "+catDescription);
				if(parent_name.equals("no parent")){
					parentId = 0;
				}
				else{
				parentId = rs.getInt(4);
			//	System.out.println("catParentid = "+parentId);
				}
				//System.out.println(" "+catName+"  "+catLevel+" "+catDescription+" "+" "+parentId);
			}
		} catch (SQLException e) {
			System.out.println("error in sql");
			e.printStackTrace();
			return false;
		}
		
		try{
			
			ps2 = conn.prepareStatement(ADD_NEW_CATEGORY);
			
			ps2.setString(1,catName);
			ps2.setInt(2,catLevel);
			ps2.setString(3,catDescription);
			ps2.setInt(4,parentId);
			
			ps2.executeUpdate();
			
			
		}catch(SQLException e1){
			
			e1.printStackTrace();
			return false;
		}
		
		try{
			
			ps =  conn.prepareStatement(deleteQuery);
			
			ps.executeUpdate();
			
		}catch(SQLException e){
			
			e.printStackTrace();
			return false;
		}
		
		
		
		return true;
	}


	@Override
	public String getAdminEmailId(int adminid) {
		String adminEmailId = null;
		
		String query = "select l_mailid from flipkart.login where login_id = "+adminid+";";
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		
		try{
			
			ps = conn.prepareStatement(query);
			
			ResultSet  rs =  ps.executeQuery();
			
			while(rs.next()){
				adminEmailId = rs.getString(1);
				
			}
			
		}catch(SQLException e){
			
			e.printStackTrace();
			return null;
		}
		return adminEmailId;
	}


	@Override
	public boolean removeFromNotify(int notificationId) {
		
		String deleteQuery = "delete from flipkart.category_notification where category_notificationid ="+notificationId+";";
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		
		try{
			
			ps = conn.prepareStatement(deleteQuery);
			
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	

	public Map<String,String> getCategoryList(String categoryLevel) {
		
		Map<String,String> categoryList=new LinkedHashMap<String,String>();
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps =  null;
		try {
			ps =  conn.prepareStatement(GET_CATEGORY_BY_LEVEL1);
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
		


}
