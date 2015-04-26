package org.iiitb.flipkart.action.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddProduct extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	private String productName;
	private int productPrice;
	private int warranty;
	private String color;
	private int deliveryCharge;
	private String productSize;
	private String description="";
	
	private String kf="";
	private String specs="";
	private String category;
	private List<String> categoryList = new ArrayList<String>();
	private HttpServletRequest servletRequest;
	private String productImage;

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}


	public String initialize(){

		ProductDAO getList = new ProductDAOImpl();
		categoryList = getList.getAllLevel2Category();

		return SUCCESS;
	}

	public String execute(){


	ProductDAO storeDetails = new ProductDAOImpl();

		FileInputStream inputStream = null;
		try {
			//System.out.println(productImage);
		inputStream = new FileInputStream(new File(productImage));
		} catch (Exception e) {
			e.printStackTrace();
		}
//System.out.println(inputStream);
boolean result = storeDetails.insertDetails(productName,productPrice,warranty,inputStream,color
				,deliveryCharge,productSize,category,description,specs,kf);
		if(result == true){
			return "success";
		}
		else{
			return ERROR;
		}
		
	}
	public String getProductImage() {
		return productImage;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKf() {
		return kf;
	}

	public void setKf(String kf) {
		this.kf = kf;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

}
