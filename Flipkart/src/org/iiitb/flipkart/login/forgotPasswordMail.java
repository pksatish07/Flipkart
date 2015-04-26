package org.iiitb.flipkart.login;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class forgotPasswordMail {

	

	public boolean sendmail(String forgotMailId, String newPasssword) {
		
		String mail =forgotMailId;
		String host = "smtp.gmail.com";
		String port = "465";
		//String msgBody = "Use "+newPasssword+"as password to login";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		final String userName = "ooadproject2015@gmail.com";
		final String password = "kartilla2015";
		String message =  "Hello!!! Use "+newPasssword+" as your password to login into Flipkart.Thanku ";
		
		try
	    {
	    	


	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");
	    	Session session= Session.getDefaultInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(userName,password);
	                    }
	                });
	    	Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(userName));
	        msg.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(mail));
	        msg.setSubject("Password Recovery");
	        msg.setText(message);
	        msg.setContent(message,"text/html");
	        Transport.send(msg);

return true;
	    }
	    catch (MessagingException e) 
	    {
	      System.out.println(e.getLocalizedMessage());
	      return false;
	    }
		
		
		
	}

}
