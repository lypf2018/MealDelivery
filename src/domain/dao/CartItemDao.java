package domain.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.MySQLJDBC;
import domain.bean.*;


public class CartItemDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	
	
	public List<CartItem> getCartDishes(int cid) {
		mySQLJDBC.setPreparedSql("select * from \r\n" + 
				"cart join dish on\r\n" + 
				"cart.did = dish.did\r\n" + 
				"join category on \r\n" + 
				"category.catid = dish.categoryid\r\n" + 
				"where cart.cid = ?;", cid);
		ResultSet res = mySQLJDBC.excuteQuery();
		List<CartItem> items = new LinkedList<>();
		try {
			while ((res != null) && (res.next())) {
				CartItem cur = new CartItem(res.getInt("did"), res.getInt("quantity"));
				cur.setCategoryId(res.getInt("catid"));
				cur.setCategoryName(res.getString("category.name"));
				cur.setName(res.getString("dish.name"));
				cur.setPrice(res.getInt("price"));
				items.add(cur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	

	/**
	 * Before releasing resources, execute mySQLJDBC.close() method to ensure
	 * this.preparedStatement and this.connection has been closed 
	 */
	protected void finalize() throws Throwable {
		mySQLJDBC.close();
		super.finalize();
	}


}
