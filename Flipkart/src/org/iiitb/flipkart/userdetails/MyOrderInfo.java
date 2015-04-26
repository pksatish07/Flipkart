package org.iiitb.flipkart.userdetails;

import java.io.InputStream;

public class MyOrderInfo {
  
  
   private String pname;
   private int price;
   private int productId;
   private int orderid;
   InputStream photo;
   public InputStream getPhoto() {
	return photo;
}
public void setPhoto(InputStream photo) {
	this.photo = photo;
}
private  String pcolor;
   private  String psize;
   private  int pquantity;
   private String pstatus;
   private String pseller;
   private String description;
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public String getPcolor() {
	return pcolor;
}
public void setPcolor(String pcolor) {
	this.pcolor = pcolor;
}
public String getPsize() {
	return psize;
}
public void setPsize(String psize) {
	this.psize = psize;
}
public int getPquantity() {
	return pquantity;
}
public void setPquantity(int pquantity) {
	this.pquantity = pquantity;
}
public String getPstatus() {
	return pstatus;
}
public void setPstatus(String pstatus) {
	this.pstatus = pstatus;
}
public String getPseller() {
	return pseller;
}
public void setPseller(String pseller) {
	this.pseller = pseller;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}

  


}
