package org.iiitb.flipkart.cart;
//p.p_name,p.p_price,p.p_warranty_months,p.p_colour,p.p_deliverycharge,p.p_size,seller.seller_name,c.p_quantity,p.product_id
public class CartVO {
private String item;
private int quantity;
private int price;
private int deliveryCharge;
private String productName;
private int warrantyMonths;
private String colour;
private String size;
private int productId;
private String sellerName;
private int totalPrice;
private int sellerId;
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getWarrantyMonths() {
	return warrantyMonths;
}
public void setWarrantyMonths(int warrantyMonths) {
	this.warrantyMonths = warrantyMonths;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getSellerName() {
	return sellerName;
}
public void setSellerName(String sellerName) {
	this.sellerName = sellerName;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public int getQuantatity() {
	return quantity;
}
public void setQuantatity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getDeliveryCharge() {
	return deliveryCharge;
}
public void setDeliveryCharge(int deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
public int getSellerId() {
	return sellerId;
}
public void setSellerId(int sellerId) {
	this.sellerId = sellerId;
}

}
