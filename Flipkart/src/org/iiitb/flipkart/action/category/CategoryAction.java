package org.iiitb.flipkart.action.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport implements Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String catLevel;
	private List<String> parentCatList = new ArrayList<String>();
	private Map<String,String> catList = new HashMap<String,String>();
	public Map<String, String> getCatList() {
		return catList;
	}

	public void setCatList(Map<String, String> catList) {
		this.catList = catList;
	}

	private String[] list;
	private String dummyMsg;

	public String execute(){

		CategoryDAO categories = new CategoryDAOImpl();
		//System.out.println("catLevel= "+catLevel);
		setParentCatList(categories.getCategoryNames(catLevel));
		
		int i=0;
		for(String s:parentCatList){
			i++;
			String str = ""+i;
			catList.put(str,s);
		}
		return SUCCESS;
	}
	
	public String initialize(){
		
		setCatLevel("0");
		parentCatList.add("none");
		return SUCCESS;
	}


	public String getCatLevel() {
		return catLevel;
	}

	public void setCatLevel(String catLevel) {
		this.catLevel = catLevel;
	}

	public List<String> getParentCatList() {
		return parentCatList;
	}

	public void setParentCatList(List<String> parentCatList) {
		this.parentCatList = parentCatList;
	}

	public Map<String,String> getCatMap() {
		return catList;
	}

	public void setCatMap(Map<String,String> catList) {
		this.catList = catList;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

}
