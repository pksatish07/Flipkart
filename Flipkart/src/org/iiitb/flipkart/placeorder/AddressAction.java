package org.iiitb.flipkart.placeorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.iiitb.flipkart.placeorder.AddressDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport implements Action {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AddressVO> list=new ArrayList<AddressVO>();
	private HashMap<String,AddressVO> listMap = new LinkedHashMap<String,AddressVO>();
	private HashMap<String,String> templist=new LinkedHashMap<String,String>();
	
	public HashMap<String, AddressVO> getListMap() {
		return listMap;
	}

	public void setListMap(HashMap<String, AddressVO> listMap) {
		this.listMap = listMap;
	}
	private String email;
	
	public String execute()
	{
	
		AddressDAO addr=new AddressDAOImpl();
		list = addr.getAddressList(email);
		int i=0;
		for(AddressVO temp : list){
			i++;
			listMap.put(i+"", temp);
			System.out.println(temp.getCustomerName());
				
		}
		System.out.println("++++"+listMap.get("1").getCustomerName());
		templist.put("1", "RAJEEV");
		return SUCCESS;
	}
	
	public List<AddressVO> getList() {
		return list;
	}
	public void setList(List<AddressVO> list) {
		this.list = list;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public HashMap<String,String> getTemplist() {
		return templist;
	}

	public void setTemplist(HashMap<String,String> templist) {
		this.templist = templist;
	}

}
