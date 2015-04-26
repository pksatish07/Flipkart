package org.flipkart.accountinfo;

import java.sql.Connection;

public interface AccountDao {
	public String AccountInfo(Connection con,String AccNo);
	public String CreditInfo(Connection con,String CreditNo);

}
