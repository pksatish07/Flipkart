package org.iiitb.flipkart.stock;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

/**
 * A utility class for sending e-mail with attachment.
 * @author www.codejava.net
 *
 */
public class EmailUtility {
	
	
	private Session session;
	private String username,password;
	
	
    public String sendMailToAdmin(String user) {

        
        try
        {
        	username = "kartilla007@gmail.com";
            password = "qwertykartilla";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
        	session= Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username,password);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user));
            message.setSubject("Low Stock");
            message.setText("Bawa Kuch kro");

            Transport.send(message);

            return "success";

        }
        catch (MessagingException e) 
        {
          System.out.println(e.getLocalizedMessage());
        }
		return "failure";
    }
   
	
}					
	
