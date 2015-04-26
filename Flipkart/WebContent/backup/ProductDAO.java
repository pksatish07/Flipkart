package org.iiitb.flipkart.action.product;

import java.io.FileInputStream;
import java.util.List;

public interface ProductDAO {

	public List<String> getAllLevel2Category();

	public boolean insertDetails(String productName, int productPrice,
			int warranty, FileInputStream inputStream, String color,
			int deliveryCharge, String productSize, String category);
	
}
