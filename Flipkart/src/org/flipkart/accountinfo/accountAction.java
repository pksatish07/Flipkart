package org.flipkart.accountinfo;

import java.sql.Connection;

import org.iiitb.flipkart.login.loginDAO;
import org.iiitb.flipkart.login.loginDAOimpl;

import com.flipkart.util.ConnectionPool;
import com.opensymphony.xwork2.ActionSupport;

public class accountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private String accountId;
 private String creditId;
 private String  amountAcc;
 private String amountCrd;
public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public String getCreditId() {
	return creditId;
}
public void setCreditId(String creditId) {
	this.creditId = creditId;
}

public String AccountInfo(){
	Connection connection = ConnectionPool.getConnection();
	AccountDao acc=new AccountDaoImpl();
	amountAcc=acc.AccountInfo(connection, accountId);
	
	ConnectionPool.freeConnection(connection);
	return SUCCESS;
}
public String CreditInfo(){
	Connection connection = ConnectionPool.getConnection();
	AccountDao acc=new AccountDaoImpl();
	amountCrd=acc.CreditInfo(connection, creditId);
	
	ConnectionPool.freeConnection(connection);
	return SUCCESS;
}
public String getAmountAcc() {
	return amountAcc;
}
public void setAmountAcc(String amountAcc) {
	this.amountAcc = amountAcc;
}
public String getAmountCrd() {
	return amountCrd;
}
public void setAmountCrd(String amountCrd) {
	this.amountCrd = amountCrd;
}
}
