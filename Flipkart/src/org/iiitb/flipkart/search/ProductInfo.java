package org.iiitb.flipkart.search;

public class ProductInfo {
	

	private int productId;
	private String productName;
	private String productPrice;
	private int stockCount;
	private boolean isThereStock = false;
	
	
	public int getStockCount() {
		return stockCount;
	}




	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}




	public ProductInfo(int id,String name,String price,int stockCount)
	{
		this.productId=id;
		this.productName=name;
		this.productPrice=price;
		this.stockCount = stockCount;
		
		if(this.stockCount > 0)
		{
			this.isThereStock = true;
		}
		else
		{
			this.isThereStock = false;
		}
	}
	
	
	
	
	public boolean isIsThereStock() {
		return isThereStock;
	}




	public void setIsThereStock(boolean isThereStock) {
		this.isThereStock = isThereStock;
	}




	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}



	
	

}
