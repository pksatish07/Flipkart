package org.iiitb.flipkart.login;

import java.sql.Connection;

public interface loginDAO {

	public boolean CheckUserMailId(Connection con,String Email,String password);
	public String getUserType(String mailID, Connection connection);
	public boolean signUpNewUser(Connection connection, String signupId,
			String signUpPassId,String UserType);

	public User getUser(Connection connection, String mailID);

	public boolean checkValid(Connection connection, String mailId);

	public void resetPassword(Connection connection, String forgotMailId,
			String newPasssword);
}
