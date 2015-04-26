package org.iiitb.flipkart.action.category;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddNewCategory extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String categoryName;
	private String description;
	private String categoryLevel = "";
	private String parentName;
	private SessionMap<String,Object> session;


	public String execute(){
		
		
		if(categoryLevel.equals("0")){
			
			parentName = "no parent";
		}
		
		CategoryDAO store = new CategoryDAOImpl();
		
		int admin_id = 4;
		boolean result = store.addToNotifyCategory(categoryName,description,categoryLevel,parentName,admin_id);
		if(result == false){
			return ERROR;
		}
		
		String mail = store.getAdminEmailId(admin_id);
		String host = "smtp.gmail.com";
		String port = "465";
		String msgBody = "http://localhost:8080/Flipkart/approveCategory";
		
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		final String userName = "pksatish07@gmail.com";
		final String password = "pksatish03";
		String message = "http://localhost:8080/Flipkart/approveCategory";

		/*Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						"pksatish07@gmail.com", "pksatish03");
			}
		};*/
		
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
	        msg.setSubject("New Product Category Addition");
	        msg.setText(message);
	        msg.setContent(message,"text/html");
	        Transport.send(msg);


	    }
	    catch (MessagingException e) 
	    {
	      System.out.println(e.getLocalizedMessage());
	    }
		
		/*try {
			
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("pksatish07@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					mail));
			msg.setSubject("New Category for Approval");
			msg.setText(msgBody);
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
*/
		return SUCCESS;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategoryLevel() {
		return categoryLevel;
	}


	public void setCategoryLevel(String categoryLevel) {
		this.categoryLevel = categoryLevel;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	@Override
	public void setSession(Map<String, Object> sessionAttributes)
	{
		this.session = (SessionMap<String, Object>)sessionAttributes;	
	}

	public SessionMap<String, Object> getSession()
	{
		return session;
	}

}
