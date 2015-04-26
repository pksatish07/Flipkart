package org.iiitb.flipkart.action.category;

public class CategoryDetails {
	
	private String categoryName;
	private String description;
	private int categoryLevel;
	private String parentName;
	private int adderAdminId;
	private String admin_fname;
	private String admin_lname;
	private int NotificationId;
	
	
	public String getAdmin_fname() {
		return admin_fname;
	}
	public void setAdmin_fname(String admin_fname) {
		this.admin_fname = admin_fname;
	}
	public String getAdmin_lname() {
		return admin_lname;
	}
	public void setAdmin_lname(String admin_lname) {
		this.admin_lname = admin_lname;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public int getAdderAdminId() {
		return adderAdminId;
	}
	public void setAdderAdminId(int adderAdminId) {
		this.adderAdminId = adderAdminId;
	}
	public int getNotificationId() {
		return NotificationId;
	}
	public void setNotificationId(int notificationId) {
		NotificationId = notificationId;
	}
	

}
