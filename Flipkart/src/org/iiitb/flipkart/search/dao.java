package org.iiitb.flipkart.search;

import java.util.ArrayList;
import java.util.List;

public interface dao {
	
	public List<String> getNames() ;

	public int getStatus(String product);

	public List<ProductInfo> getLevel2(String product);

	public List<ProductInfo> getLevel1(String product);

	public List<ProductInfo> getLevel2(String product,int low,int high);

	public List<ProductInfo> getLevel1(String product,int low,int high);

	public ProductImage getImage(int productId);

	public List<ProductInfo> getLevel0(String product);
	
	public List<ProductInfo> getLevel0(String product ,int low,int high);

	public ArrayList<String> getFrameWork(String term);

}
