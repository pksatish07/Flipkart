package org.iiitb.flipkart.payment;

import java.util.HashMap;

public interface PaymentDao {
	
	public  CreditCardDetails c_pay(PayAction details);
	public void transferAmt(CreditCardDetails cd,HashMap<Integer,Integer> ordercosts);
	

}
