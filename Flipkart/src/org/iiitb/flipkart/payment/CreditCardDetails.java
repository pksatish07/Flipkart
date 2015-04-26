package org.iiitb.flipkart.payment;

public class CreditCardDetails {
	
	private long cCardNo;
	private int cvv;
	private int pin;
	private int limit;
	private String expDate;
	private String nameOnCard;
	private int availbalance;
	
	public int getAvailbalance() {
		return availbalance;
	}
	public void setAvailbalance(int availbalance) {
		this.availbalance = availbalance;
	}
	public long getcCardNo() {
		return cCardNo;
	}
	public void setcCardNo(long cCardNo) {
		this.cCardNo = cCardNo;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	

}
