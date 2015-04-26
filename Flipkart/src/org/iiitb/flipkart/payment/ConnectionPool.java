package org.iiitb.flipkart.payment;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

	private static DataSource dataSource;

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		ConnectionPool.dataSource = dataSource;
	}

	public static Connection getConnection(){
		Connection conn = null;

		try {
			if(dataSource!=null){
				conn = dataSource.getConnection();
			}else{
				
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/flipkart");
				conn = dataSource.getConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static void freeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

