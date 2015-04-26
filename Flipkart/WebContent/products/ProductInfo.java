package com.flipkart.products;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Subject Info
 * @author arjun
 *
 */
public class ProductInfo {

  public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

private int pid;
  private String name = "";
  private int price = -1;
  private int warrantyMonths = -1;
  private String colour = "";
  private int deliveryCharge = -1;
  private InputStream photo =null;
  private String description = "";
  private String keyfeatures = "";
  private String specs = "";

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getKeyfeatures() {
	return keyfeatures;
}

public void setKeyfeatures(String keyfeatures) {
	this.keyfeatures = keyfeatures;
}

public String getSpecs() {
	return specs;
}

public void setSpecs(String specs) {
	this.specs = specs;
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

public int getDeliveryCharge() {
	return deliveryCharge;
}

public void setDeliveryCharge(int deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

private String size = "";
  

  public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public ProductInfo() {
    super();
  }

  public ProductInfo(int productId, String name, int price, int warrantyMonths, String colour, int deliveryCharge, String size, String description, String keyfeatures, String specs) {
    super();
    this.pid = productId;
    this.name = name;
    this.price = price;
    this.warrantyMonths = warrantyMonths;
    this.colour = colour;
    this.size = size;
    this.deliveryCharge = deliveryCharge;
    
    this.description = description;
    this.specs = specs;
    this.keyfeatures = keyfeatures;
    
    
  }
  
  public ProductInfo(int productId,InputStream photo)
  {
	  this.pid = productId;
	  this.photo = photo;
  }
  
  public ProductInfo(String productName,InputStream photo)
  {
	  this.name = productName;
	  this.photo = photo;
  }
  
  

  
  

  
}
