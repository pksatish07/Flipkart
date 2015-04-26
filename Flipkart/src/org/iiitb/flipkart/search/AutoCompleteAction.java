package org.iiitb.flipkart.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class AutoCompleteAction implements Action 
{
	public List<String> products = new ArrayList<String>();
	public List<ProductInfo> productInfo ;

	public boolean isAllDisplayed = true;

	public String input = "";
	public String index = "-1";
	
	public String selectedOption = "";
	
	public String getSelectedOption() {
		return selectedOption;
	}



	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}



	public String getInput() {
		return input;
	}



	public String getIndex() {
		return index;
	}



	public void setIndex(String index) {
		this.index = index;
	}



	public void setInput(String input) {
		this.input = input;
	}


	public boolean isIsAllDisplayed() {
		return isAllDisplayed;
	}



	public void setIsAllDisplayed(boolean isAllDisplayed) {
		this.isAllDisplayed = isAllDisplayed;
	}


	

	public List<String> getFilterOptions() {
		return filterOptions;
	}

	public void setFilterOptions(List<String> filterOptions) {
		this.filterOptions = filterOptions;
	}

	public String product;
	// Received via Ajax request
	private String term;
	// Returned as responce
	private ArrayList<String> list;


	public boolean showFilter = false;
	
	public boolean isShowFilter() {
		return showFilter;
	}

	public void setShowFilter(boolean showFilter) {
		this.showFilter = showFilter;
	}
	public List<String> filterOptions = new ArrayList<String>();


	dao object = new daoImpl();

	public String execute() 
	{
		try {
			System.out.println("Parameter from ajax request : - " + term);
			list = object.getFrameWork(term);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return SUCCESS;


		/*products = object.getNames();
		return "success";*/
	}

	public String displayProduct() 
	{
		System.out.println("In displayProduct");
		int categoryStatus;
		System.out.println(getProduct());
		productInfo = new ArrayList<ProductInfo>();
		categoryStatus = object.getStatus(product);
		System.out.println("Category : "+categoryStatus);
		if(categoryStatus == 0 ){
			productInfo = object.getLevel0(product);
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			}
			
				
		}
		if(categoryStatus == 2){
			productInfo = object.getLevel2(product);	
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			}
		}
		if(categoryStatus == 1){
			productInfo = object.getLevel1(product);
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			} 
			determineFilters();
		}
		if(categoryStatus == 3){
			productInfo = object.getLevel0(product);
			showFilter = false;

		}

		/* everybody have to include this 2 line*/
		dao object = new daoImpl();
		products = object.getNames();
		
		isAllDisplayed = true;
		return "success";


	}




	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String descSort()
	{
		System.out.println("In descSort");
		int categoryStatus;
		System.out.println(getProduct());
		productInfo = new ArrayList<ProductInfo>();
		categoryStatus = object.getStatus(product);
		System.out.println("Category : "+categoryStatus);
		if(categoryStatus == 0 ){
			productInfo = object.getLevel0(product);
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			}


		}
		if(categoryStatus == 2){
			productInfo = object.getLevel2(product);	
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			}
		}
		if(categoryStatus == 1){
			productInfo = object.getLevel1(product);
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			} 
			determineFilters();
		}
		if(categoryStatus == 3){
			productInfo = object.getLevel0(product);
			showFilter = false;

		}

		Collections.sort(productInfo, new Comparator<ProductInfo>() {
			@Override
			public int compare(final ProductInfo object1, final ProductInfo object2) {
				return -(Integer.parseInt(object1.getProductPrice()) - Integer.parseInt(object2.getProductPrice()));
			}
		} );
		/* everybody have to include this 2 line*/
		dao object = new daoImpl();
		products = object.getNames();

		isAllDisplayed = true;

		return "success";
	}

	public String ascSort()
	{
		System.out.println("In ascSort");
		int categoryStatus;
		System.out.println(getProduct());
		productInfo = new ArrayList<ProductInfo>();
		categoryStatus = object.getStatus(product);
		System.out.println("Category : "+categoryStatus);
		if(categoryStatus == 0 ){
			productInfo = object.getLevel0(product);
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			}


		}
		if(categoryStatus == 2){
			productInfo = object.getLevel2(product);	
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			}
		}
		if(categoryStatus == 1){
			productInfo = object.getLevel1(product);
			if(productInfo.size()>1)
			{
				showFilter = true;
				determineFilters();
			} 
			determineFilters();
		}
		if(categoryStatus == 3){
			productInfo = object.getLevel0(product);
			showFilter = false;

		}

		Collections.sort(productInfo, new Comparator<ProductInfo>() {
			@Override
			public int compare(final ProductInfo object1, final ProductInfo object2) {
				return (Integer.parseInt(object1.getProductPrice()) - Integer.parseInt(object2.getProductPrice()));
			}
		} );
		/* everybody have to include this 2 line*/
		dao object = new daoImpl();
		products = object.getNames();

		isAllDisplayed = true;
		return "success";
	}

	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}



	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}



	public String descSortInRange()
	{

		System.out.println("In DescSortInRange : "+input);
		int categoryStatus = 0;
		productInfo = new ArrayList<ProductInfo>();
		categoryStatus = object.getStatus(product);
		System.out.println("Category : "+categoryStatus);

		String [] parts = input.split(":\\[");
		String [] options = parts[0].split(":");
		setProduct(options[0]);

		String [] filterOps = parts[1].substring(0,parts[1].length()-1).split(", ");

		for(int i=0;i<filterOps.length;i++)
		{
			filterOptions.add(filterOps[i]);
		}

		String selectedFilter = filterOptions.get(Integer.parseInt(options[1])).split(":")[0];
		setIndex(options[1]);
		String [] selectedFilterParts = selectedFilter.split(" to ");
		int low = Integer.parseInt(selectedFilterParts[0].replace("Rs. ", ""));
		int high =  Integer.parseInt(selectedFilterParts[1].replace("Rs. ", ""));
		System.out.println("Lower limit : "+low +" Upper limit : "+high);

		categoryStatus = object.getStatus(product);
		if(categoryStatus == 0 ){
			productInfo = object.getLevel0(product,low,high);
			showFilter = true;



		}
		if(categoryStatus == 2){
			productInfo = object.getLevel2(product,low,high);
			showFilter = true;
		}
		if(categoryStatus == 1){
			productInfo = object.getLevel1(product,low,high);
			showFilter = true;
		}
		if(categoryStatus == 3){
			productInfo = object.getLevel0(product,low,high);;
			showFilter = true;

		}


		Collections.sort(productInfo, new Comparator<ProductInfo>() {
			@Override
			public int compare(final ProductInfo object1, final ProductInfo object2) {
				return -(Integer.parseInt(object1.getProductPrice()) - Integer.parseInt(object2.getProductPrice()));
			}
		} );
		/* everybody have to include this 2 line*/
		dao object = new daoImpl();
		products = object.getNames();

		isAllDisplayed = false;
		return "success";
	}

	public String ascSortInRange()
	{
		System.out.println("In AscSortInRange : "+input);
		int categoryStatus = 0;
		productInfo = new ArrayList<ProductInfo>();
		categoryStatus = object.getStatus(product);
		System.out.println("Category : "+categoryStatus);

		String [] parts = input.split(":\\[");
		String [] options = parts[0].split(":");
		setProduct(options[0]);

		String [] filterOps = parts[1].substring(0,parts[1].length()-1).split(", ");

		for(int i=0;i<filterOps.length;i++)
		{
			filterOptions.add(filterOps[i]);
		}

		String selectedFilter = filterOptions.get(Integer.parseInt(options[1])).split(":")[0];
		setIndex(options[1]);
		String [] selectedFilterParts = selectedFilter.split(" to ");
		int low = Integer.parseInt(selectedFilterParts[0].replace("Rs. ", ""));
		int high =  Integer.parseInt(selectedFilterParts[1].replace("Rs. ", ""));
		System.out.println("Lower limit : "+low +" Upper limit : "+high);

		categoryStatus = object.getStatus(product);

		if(categoryStatus == 0 ){
			productInfo = object.getLevel0(product,low,high);
			showFilter = true;



		}
		if(categoryStatus == 2){
			productInfo = object.getLevel2(product,low,high);
			showFilter = true;
		}
		if(categoryStatus == 1){
			productInfo = object.getLevel1(product,low,high);
			showFilter = true;
		}
		if(categoryStatus == 3){
			productInfo = object.getLevel0(product,low,high);
			showFilter = true;

		}


		Collections.sort(productInfo, new Comparator<ProductInfo>() {
			@Override
			public int compare(final ProductInfo object1, final ProductInfo object2) {
				return (Integer.parseInt(object1.getProductPrice()) - Integer.parseInt(object2.getProductPrice()));
			}
		} );
		/* everybody have to include this 2 line*/
		dao object = new daoImpl();
		products = object.getNames();

		isAllDisplayed = false;
		return "success";
	}

	public String displayProductsInRange() 
	{
		int categoryStatus;
		System.out.println("In displayProductsInRange");
		System.out.println("Selected option : "+selectedOption);
		String []mainOptions = selectedOption.split(":\\[");
		String []options = mainOptions[0].split(":");
		String []range = options[0].split("to");
		String []values = new String[2];
		values[0] = range[0].replace("Rs.","");
		values[1] = range[1].replace("Rs.","");
		setProduct(options[2]);
		String [] filterOps = mainOptions[1].substring(0, mainOptions[1].length()-1).split(", ");

		for(int i=0;i<filterOps.length;i++)
		{
			filterOptions.add(filterOps[i]);
		}
		setFilterOptions(filterOptions);
		setIndex(options[3]);
		int count = Integer.parseInt(options[1].replace("(", "").replace(")",""));
		System.out.println(getProduct());

		productInfo = new ArrayList<ProductInfo>();
		categoryStatus = object.getStatus(product);
		System.out.println("Category : "+categoryStatus);
		if(categoryStatus == 0 ){
			productInfo = object.getLevel0(product,Integer.parseInt(values[0]),Integer.parseInt(values[1]));
			showFilter = true;



		}
		if(categoryStatus == 2){
			productInfo = object.getLevel2(product,Integer.parseInt(values[0]),Integer.parseInt(values[1]));
			showFilter = true;
		}
		if(categoryStatus == 1){
			productInfo = object.getLevel1(product,Integer.parseInt(values[0]),Integer.parseInt(values[1]));
			showFilter = true;
		}
		if(categoryStatus == 3){
			productInfo = object.getLevel0(product,Integer.parseInt(values[0]),Integer.parseInt(values[1]));
			showFilter = true;

		}

		/* everybody have to include this 2 line*/
		dao object = new daoImpl();
		products = object.getNames();

		isAllDisplayed = false;
		return "success";


	}

	public String htol()
	{
		System.out.println("in htol");
		return "success";
	}
	public String ltoh()
	{
		System.out.println("in ltoh");
		return "success";
	}
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void determineFilters()
	{
		int max = Integer.parseInt(productInfo.get(0).getProductPrice());
		int min = Integer.parseInt(productInfo.get(0).getProductPrice());
		int [] count = new int[6];
		for(int i=0;i<productInfo.size();i++)
		{
			String curPrice = productInfo.get(i).getProductPrice();
			System.out.println("Price : "+curPrice);
			if(Integer.parseInt(curPrice)>max)
			{
				max = Integer.parseInt(curPrice);
			}
			else if(Integer.parseInt(curPrice)<min)
			{
				min = Integer.parseInt(curPrice);
			}
		}
		System.out.println("Max Price : "+max);
		System.out.println("Max Price : "+min);

		int interval = (max-min)/6;
		for(int i=0;i<6;i++)
		{
			int low = min+i*interval;
			low = estimateLow(low,i);
			/*int low;
			if(i==0)
			{
				low = (min+i*interval) - (min+i*interval)%100 + 1;
			}
			else
			{
				low = (min+i*interval) - (min+i*interval)%100 + 100 + 1;
			}
			 */
			int high;

			if(i!=5)
				//high =  (min+(i+1)*interval) - (min+(i+1)*interval)%100 + 100 + 1;
				high =  (min+(i+1)*interval);
			else
				//high = max - max%100 + 100;
				high = max; 

			high = estimateHigh(high);
			count[i] = 0;
			for(int j=0;j<productInfo.size();j++)
			{
				if(Integer.parseInt(productInfo.get(j).getProductPrice()) >=low &&Integer.parseInt(productInfo.get(j).getProductPrice()) <=high)
				{
					count[i]++;
				}
			}

		}

		for(int i=0;i<6;i++)
		{
			int low = min+i*interval;
			int high = min+(i+1)*interval;
			//int low = min+i*interval;
			/*int low;
			if(i==0)
			{
				low = (min+i*interval) - (min+i*interval)%100 + 1;
			}
			else
			{
				low = (min+i*interval) - (min+i*interval)%100 + 100 + 1;
			}
			int high;*/

			if(i!=5)
				//high =  (min+(i+1)*interval) - (min+(i+1)*interval)%100 + 100;
				high =  (min+(i+1)*interval);
			else
				//high = max - max%100 + 100;
				high = max;

			low = estimateLow(low, i);
			high = estimateHigh(high);

			/*
			if(i==0)
				filterOptions.add("Rs. "+low+" to Rs. "+high +":("+count[i]+")");
			else if(i!=5)
				filterOptions.add("Rs. "+(low+1)+" to Rs. "+high +":("+count[i]+")");
			else
				filterOptions.add("Rs. "+(low+1)+" to Rs. "+max +":("+count[i]+")");*/


			filterOptions.add("Rs. "+low+" to Rs. "+high +":("+count[i]+")");
		}

	}

	public int estimateLow(int val,int index)
	{
		if(index==0)
		{
			return (val-val%100 + 1);
		}
		else
		{
			return (val-val%100 + 100 + 1);
		}
	}

	public int estimateHigh(int val)
	{

		if(val%100 == 0)
		{
			return (val);
		}
		else
		{
			return (val-val%100 +100);
		}


	}



}
