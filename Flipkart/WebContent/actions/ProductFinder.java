package com.flipkart.actions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.flipkart.daoimpl.ProductDAOImpl;
import com.flipkart.products.ProductInfo;
import com.flipkart.util.ConnectionPool;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class ProductFinder extends ActionSupport {

	public boolean isHasSpecs() {
		return hasSpecs;
	}

	public void setHasSpecs(boolean hasSpecs) {
		this.hasSpecs = hasSpecs;
	}

	public boolean isHasKf() {
		return hasKf;
	}

	public void setHasKf(boolean hasKf) {
		this.hasKf = hasKf;
	}

	public boolean isHasDesc() {
		return hasDesc;
	}

	public void setHasDesc(boolean hasDesc) {
		this.hasDesc = hasDesc;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pid = "";
	private String pName;
	private int pPrice = -1;
	private int pWarranty = -1;
	private String pColour = "";
	private int pDeliveryCharge = -1;
	private String pSize = "";
	private String desc = "";
	private String kf = "";
	private String specs = "";
	private List<String> specPairs;
	private boolean hasSpecs = false;
	private boolean hasKf = false;
	private boolean hasDesc = false;
	

	public List<String> getSpecPairs() {
		return specPairs;
	}

	public void setSpecPairs(List<String> specPairs) {
		this.specPairs = specPairs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getKfList() {
		return kfList;
	}

	public void setKfList(List<String> kfList) {
		this.kfList = kfList;
	}

	private List<String> kfList = null;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	

/*	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}*/

	public int getPPrice() {
		return pPrice;
	}

	public String getPName() {
		return pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public void setPPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getPWarranty() {
		return pWarranty;
	}

	public void setPWarranty(int pWarranty) {
		this.pWarranty = pWarranty;
	}

	public String getPColour() {
		return pColour;
	}

	public void setPColour(String pColour) {
		this.pColour = pColour;
	}

	public int getPDeliveryCharge() {
		return pDeliveryCharge;
	}

	public void setPDeliveryCharge(int pDeliveryCharge) {
		this.pDeliveryCharge = pDeliveryCharge;
	}

	public String getPSize() {
		return pSize;
	}

	public void setPSize(String pSize) {
		this.pSize = pSize;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getKf() {
		return kf;
	}

	public void setKf(String kf) {
		this.kf = kf;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public String execute(){

		System.out.println("Finding product : "+pid);
		
		  Connection connection = ConnectionPool.getConnection();
		  
		 
		    
		    ProductInfo product = null;
			try {
				
				ProductDAOImpl prodDAOimpl = new ProductDAOImpl();
				
				if(pid.matches("\\d+"))
				{
					product = prodDAOimpl.getProduct(connection, Integer.parseInt(pid));
				}
				else
				{
					product = prodDAOimpl.getProduct(connection, pid);
				}
				
				
				System.out.println("ID : "+product.getPid());
				System.out.println("Name : "+product.getName());
				System.out.println("Price : "+product.getPrice());
				System.out.println("Warranty in months  : "+product.getWarrantyMonths());
				System.out.println("Colour : "+product.getColour());
				System.out.println("Delivery charge : "+product.getDeliveryCharge());
				System.out.println("Size : "+product.getSize());
				
				System.out.println("Description : "+product.getDescription());
				System.out.println("Key features : "+product.getKeyfeatures());
				String specifications = product.getSpecs();
				System.out.println("Specifications : "+specifications);
				
				//
				if(product.getDescription() !=null)
				{
					hasDesc = true;
				}
				//List of key features
				if(product.getKeyfeatures() !=null)
				{
					hasKf = true;
					String [] keyfeatures = product.getKeyfeatures().split("\\|");
					
					kfList = new ArrayList<String>();
					
					for(int i=0;i<keyfeatures.length;i++)
					{
						kfList.add(keyfeatures[i]);
						
					}
				}
			
				if(product.getSpecs()!=null)
				{
					hasSpecs = true;
					String [] specPairsArray = specifications.split("\\|");
					specPairs = new ArrayList<String>();
					
					for(int i=0;i<specPairsArray.length;i++)
					{
						specPairs.add(specPairsArray[i]);
						
					}
					
				}
				
				pName=product.getName();
				setPPrice(product.getPrice());
				setPWarranty(product.getWarrantyMonths());
				setPColour(product.getColour());
				setPDeliveryCharge(product.getDeliveryCharge());
				setPSize(product.getSize());
				
				setDesc(product.getDescription());
				setKf(product.getKeyfeatures());
				setSpecs(product.getSpecs());
			//	setSpecPairs(specPairs);
				
				//System.out.println(getpName());
				
				/*ps1 = connection.prepareStatement("Select course_id,course.name,user.name from course,user where course.semester_id=? AND course.faculty_id=user.user_id");
				
				ps1.setInt(1,semester);
				ResultSet rs1 = ps1.executeQuery();
			
				while (rs1.next()) {
					String courseId = rs1.getString("course_id");
					System.out.println("Course ID : "+courseId);
					String subjectName = rs1.getString("course.name");
					System.out.println("Name : "+subjectName);
					String faculty = rs1.getString("user.name");
					System.out.println("Prof : "+faculty);
					
					subjectInfoList.add(new SubjectInfo(0,courseId,subjectName,faculty));
					
					*/
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
					ConnectionPool.freeConnection(connection);
				}
		return SUCCESS;
	}
	
	public String getImage() throws SQLException, IOException {
	    Connection connection = ConnectionPool.getConnection();
	    
	    
	    
	    
	    ProductDAOImpl productImpl = new ProductDAOImpl();
	    
	    OutputStream out = null;
	    if(pid.matches("\\d+"))
	    {
	    	 out = productImpl.getProductPhoto(connection, Integer.parseInt(pid));
	    }
	    else
	    {
	    	 out = productImpl.getProductPhoto(connection, pid);
	    }
	  
	   
	    ConnectionPool.freeConnection(connection);
	    return NONE;
	  }

	
	

	

}

