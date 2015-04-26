package org.iiitb.flipkart.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CartDAO {
	
	public List<CartVO> fetchCartItems(int loginId);

	public void changeCartItems(int id, int qty, int loginId);

	public void removeCartItems(int id, int loginId);
	
	public void addCartItems(ArrayList<String> queryAssist,Map<String,String> pid,String loginId);

	public int fetchCartCount(String loginId);
	
	public List<String> fetchCartId(String loginId);

	public ArrayList<CartVO> getProdDetailsFromId(String string,
			Map<String, String> qtyMap);
	

}
