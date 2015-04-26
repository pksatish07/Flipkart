package org.iiitb.flipkart.stock;
import java.util.ArrayList;
import java.util.Map;
public interface CheckStockDAO {

	public Map<String,String> getCategoryList(String categoryLevel);
	
	public Map<String,String> getSellerList();
	
	public ArrayList<ProductValueObject> getProductListOfLowStockByCategory(String cat_id);
	
	
	public ArrayList<ProductValueObject> getProductListOfLowStockBySeller(String seller_id);
}
