package org.iiitb.flipkart.search;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;



public class categoryaction {
	
	public String categoryname;
	public String categorydesc;
	public int categorydisplaychoice;
	public String p1;
	public String p2;
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydesc() {
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}

	public int getCategorydisplaychoice() {
		return categorydisplaychoice;
	}
	public void setCategorydisplaychoice(int categorydisplaychoice) {
		this.categorydisplaychoice = categorydisplaychoice;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	public String execute() throws NamingException, SQLException,
	FileNotFoundException, ClassNotFoundException{
		
		System.out.println("1:"+getCategoryname()+"2:"+getCategorydisplaychoice());
		
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/flipkart","root","root");
		
			String query1 = "INSERT INTO category (cat_name,cat_level,cat_description) values (?,?,?)";
			System.out.println("1:"+getCategoryname()+"2:"+getCategorydisplaychoice());
			
			if(getCategorydisplaychoice()==0)
			{
			PreparedStatement prepareStatement2 = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query1);
			prepareStatement2.setString(1,getCategoryname());
			prepareStatement2.setInt(2,getCategorydisplaychoice());
			prepareStatement2.setString(3,getCategorydesc());
			
	
			prepareStatement2.executeUpdate();
			}
			if(getCategorydisplaychoice()==1)
			{
				
				
				String query2="SELECT category_id from category where UPPER(cat_name) LIKE ?";
				
				String temp=getP1();
				temp=temp.toUpperCase();
				System.out.println(temp);
				
				
				PreparedStatement ps = conn.prepareStatement(query2);
			    ps.setString(1, "%" + temp + "%");
				ResultSet rs = ps.executeQuery();
			
				int id = 0; 
				while(rs.next()){
			          id  = rs.getInt("category_id");
			         System.out.println(id);
				}
				
				String query3 = "INSERT INTO category (cat_name,cat_level,cat_description,cat_parent) values (?,?,?,?)";
				PreparedStatement prepareStatement3 = (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(query3);
				prepareStatement3.setString(1,getCategoryname());
			
				prepareStatement3.setInt(2,getCategorydisplaychoice());
				prepareStatement3.setString(3,getCategorydesc());
				prepareStatement3.setInt(4,id);
				prepareStatement3.executeUpdate();
			}

		return "success";
	}
	
	

}
