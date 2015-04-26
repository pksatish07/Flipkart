package org.iiitb.flipkart.placeorder;

import java.sql.Connection;

public interface loginDAO {

	public boolean CheckUserMailId(Connection con,String Email,String password);	public boolean CheckUserMailId(Connection con,String Email);
	public String getUserType(String mailID, Connection connection);
	public boolean AddUser(Connection con,String Email,String password);
	public String AddressExists(Connection con,String Email);
}
