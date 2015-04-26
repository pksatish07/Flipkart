package org.iiitb.flipkart.stock;

public interface UpdateStockDAO {

	public String addStock(int p_id,int change_in_amount);
	public int subStock(int p_id,int change_in_amount);
}
