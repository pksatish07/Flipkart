package org.iiitb.flipkart.stock;

import com.flipkart.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStockDAOImpl implements UpdateStockDAO {

	private static final String CURR_STOCK = "select stock from product where product_id=?;";
	private static final String UPP_STOCK = "update product set stock=? where product_id=?";

	public String addStock(int p_id, int change_in_amount) {
		int current_stock = 0;
		Connection con = ConnectionPool.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement(CURR_STOCK);
			ps.setInt(1, p_id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				current_stock = rs.getInt(1);
			}
			current_stock = current_stock + change_in_amount;

			PreparedStatement ps2 = con.prepareStatement(UPP_STOCK);
			ps2.setInt(1, current_stock);
			ps2.setInt(2, p_id);

			ps2.executeUpdate();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public int subStock(int p_id, int change_in_amount) {

		int current_stock = 0;
		Connection con = ConnectionPool.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement(CURR_STOCK);
			ps.setInt(1, p_id);

			ResultSet rs = ps.executeQuery();
			while (rs.next())

			{
				current_stock = rs.getInt(1);
			}
			current_stock = current_stock - change_in_amount;

			PreparedStatement ps2 = con.prepareStatement(UPP_STOCK);
			ps2.setInt(1, current_stock);
			ps2.setInt(2, p_id);

			ps2.executeUpdate();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return current_stock;
	}
}
