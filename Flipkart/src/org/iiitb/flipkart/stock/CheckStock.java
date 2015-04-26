package org.iiitb.flipkart.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


import com.opensymphony.xwork2.Action;

public class CheckStock implements Action {

	private static final String NULL = null;

	private String dummyMsg;
	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}

	private String choice;

	private String choice2;
	private Map<String,String> list=new LinkedHashMap<String,String>();
	private List<String> result;
	private ArrayList<ProductValueObject> productlistoflowstock;
	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String execute()
	{
		System.out.println("Choice 2 uthkar arhi ahi"+choice2);
		CheckStockDAO checkstockDAOImpl=new CheckStockDAOImpl();

		if(choice.equalsIgnoreCase("category")&&choice2==NULL)
		{
			list=checkstockDAOImpl. getCategoryList("1");

		}
		else if(choice.equalsIgnoreCase("seller")&&choice2==NULL)
		{
			list=checkstockDAOImpl.getSellerList();
		}

		else if(choice.equalsIgnoreCase("category"))
		{
			CheckStockDAOImpl checktockDAOimpl=new CheckStockDAOImpl();
			productlistoflowstock=checktockDAOimpl.getProductListOfLowStockByCategory(choice2);


		}

		else
		{
			CheckStockDAOImpl checktockDAOimpl=new CheckStockDAOImpl();
			productlistoflowstock=checktockDAOimpl.getProductListOfLowStockBySeller(choice2);

		}

		return SUCCESS;
	}

	public ArrayList<ProductValueObject> getProductlistoflowstock() {
		return productlistoflowstock;
	}

	public void setProductlistoflowstock(
			ArrayList<ProductValueObject> productlistoflowstock) {
		this.productlistoflowstock = productlistoflowstock;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public Map<String, String> getList() {
		return list;
	}

	public void setList(Map<String, String> list) {
		this.list = list;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}
} 	
