package org.iiitb.flipkart.action.category;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {

	public List<String> getCategoryNames(String categoryLevel);

	public boolean addToNotifyCategory(String categoryName, String description,
			String categoryLevel, String parentName,int admin_id);
	
	public boolean addNewCategory(String categoryName, String description,
			String categoryLevel, String parentName);
	
	public List<CategoryDetails> getApproveCategoryList();

	public boolean addThisCategory(int notificationId);
	
	public String getAdminEmailId(int adminid);

	public boolean removeFromNotify(int notificationId);
	
	public Map<String,String> getSellerList();
	
	public Map<String,String> getCategoryList(String categoryLevel);
	
	
}
