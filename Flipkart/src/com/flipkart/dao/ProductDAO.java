package com.flipkart.dao;


import java.sql.Connection;
import java.util.List;

import com.flipkart.products.ProductInfo;

public interface ProductDAO {

	/**
	 * Gets all the courses
	 * 
	 * @param connection
	 * @param userId
	 * @return list of subjectInfo objects
	 */
	public ProductInfo getProduct(Connection connection, int productId);
	
	public ProductInfo getProduct(Connection connection, String productName);

	
}
