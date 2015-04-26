package org.iiitb.flipkart.action.category;

import java.util.ArrayList;
import java.util.List;

import org.iiitb.flipkart.action.category.CategoryDetails;

import com.opensymphony.xwork2.ActionSupport;

public class ApproveCategory extends ActionSupport{
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
List<CategoryDetails> list = new ArrayList<CategoryDetails>();
	
	public String initialize(){
		
		
		
		CategoryDAO getDetails = new CategoryDAOImpl();
		list = getDetails.getApproveCategoryList();
		
		return SUCCESS;
		
	}

	
	public List<CategoryDetails> getList() {
		return list;
	}

	public void setList(List<CategoryDetails> list) {
		this.list = list;
	}

	
}
