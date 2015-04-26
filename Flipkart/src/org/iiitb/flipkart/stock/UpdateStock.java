package org.iiitb.flipkart.stock;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.opensymphony.xwork2.Action;
import java.util.Properties;
public class UpdateStock implements Action {
	
	private int p_id;
	private int change_in_amount;
	private String operation;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getChange_in_amount() {
		return change_in_amount;
	}
	public void setChange_in_amount(int change_in_amount) {
		this.change_in_amount = change_in_amount;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
	public String execute()
	{
		UpdateStockDAO updatestockdAO=new UpdateStockDAOImpl();
		NotifyMeDAO notifymedao=new NotifyMeDAOImpl();
		if(operation.equalsIgnoreCase("add"))
		{
			updatestockdAO.addStock(p_id, change_in_amount);
			//Here trigger mail to the customer if he/she has requested for the product.
			
			//Finding the customers whose has requested for that product
			
			
		}
		else if(operation.equalsIgnoreCase("sub"))
		{
			int curr_stock=updatestockdAO.subStock(p_id, change_in_amount);
			
			if(curr_stock<5)
			{
				
				EmailUtility send_email=new EmailUtility();
				send_email.sendMailToAdmin("yuvraj.rkv@gmail.com");
				//Trigger the mail to Admin if the stock is less then 5 units.

			} 
			
		}
	
		return "success";
	}
	
	public void afterPayment(int p_id, int change_in_amount)
	{
		UpdateStockDAO updatestockdAO = new UpdateStockDAOImpl();
		int curr_stock = updatestockdAO.subStock(p_id, change_in_amount);
		
		if(curr_stock<5)
		{
			
			EmailUtility send_email=new EmailUtility();
			send_email.sendMailToAdmin("yuvraj.rkv@gmail.com");
			//Trigger the mail to Admin if the stock is less then 5 units.

		} 
		
	}
}
