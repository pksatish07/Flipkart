package org.iiitb.flipkart.search;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements SessionAware{
	private dao object = new daoImpl();
	private Map<String, Object> session;
	private int productId;
	public String execute() throws SQLException, IOException {
		ProductImage image = null;
		image = object.getImage(productId);
		 HttpServletResponse response = ServletActionContext.getResponse();
		    response.setContentType("image/jpeg");
		    InputStream in = image.getPhoto();
		    OutputStream out = response.getOutputStream();
		    byte[] buffer = new byte[1024];
		    int len;
		    while ((len = in.read(buffer)) != -1) {
		      out.write(buffer, 0, len);
		    }
		
		
		
		return NONE;
	}
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
