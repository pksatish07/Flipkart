package org.iiitb.flipkart.userdetails;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.flipkart.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements SessionAware {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  private int productId;

  private Map<String, Object> session;

  public String execute() throws SQLException, IOException {
    Connection connection = ConnectionPool.getConnection();
 
    MyOrderInfo myorder = new MyOrderInfo();
       myorder= new MyOrderDaoImpl().getproductimage(productId);
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("image/jpeg");
    InputStream in = myorder.getPhoto();
    OutputStream out = response.getOutputStream();
    byte[] buffer = new byte[1024];
    int len;
    while ((len = in.read(buffer)) != -1) {
      out.write(buffer, 0, len);
    }
    ConnectionPool.freeConnection(connection);
    return NONE;
  }

  public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

@Override
  public void setSession(Map<String, Object> session) {
    this.session = session;

  }


}
