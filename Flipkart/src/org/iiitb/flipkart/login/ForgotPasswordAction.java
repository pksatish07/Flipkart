package org.iiitb.flipkart.login;

import java.sql.Connection;

import org.iiitb.flipkart.common.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {

	/**
	 * 
	 */
	private String ForgotMailId;
	private String successFlag;
	private String message;

	private static final long serialVersionUID = 1L;


	public String execute(){

		if(IsValid(ForgotMailId)){
			
			boolean mailSuccess;
			String newPasssword;
			String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
					+ "abcdefghijklmnopqrstuvwxyz"
					+ "0123456789";
			StringBuilder builder = new StringBuilder();
			int count=6;
			while (count-- != 0) {

				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			
			newPasssword=builder.toString();
			forgotPasswordMail mailToUser= new forgotPasswordMail();
			Connection connection = ConnectionPool.getConnection();		
			loginDAO changePwd=new loginDAOimpl();
			changePwd.resetPassword(connection,ForgotMailId,newPasssword);
			ConnectionPool.freeConnection(connection);
			
			
			
			mailSuccess=mailToUser.sendmail(ForgotMailId,newPasssword);
			if(mailSuccess){
				successFlag="T";
				message="Password has been sent to "+ForgotMailId;
				return SUCCESS;
			}
			else{ 
				successFlag="F";
				message="MailId not registered";

				return SUCCESS;
			}
		}
		else{
			successFlag="F";
			message="MailId not registered";

			return SUCCESS;
		}
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	private boolean IsValid(String MailId) {
		boolean validuser;
		Connection connection = ConnectionPool.getConnection();

		loginDAO valid=new loginDAOimpl();
		validuser=valid.checkValid(connection,MailId);
		ConnectionPool.freeConnection(connection);
		return validuser;
	}



	public String getForgotMailId() {
		return ForgotMailId;
	}


	public void setForgotMailId(String forgotMailId) {
		ForgotMailId = forgotMailId;
	}




	public String getSuccessFlag() {
		return successFlag;
	}


	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}
}
