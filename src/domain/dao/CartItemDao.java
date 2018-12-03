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
	
	public boolean insertCart(int cid, String did, int quantity) {
		mySQLJDBC.setPreparedSql("insert into cart (cid, did, quantity)\r\n" + 
				"values (?, ?, ?);", cid, did, quantity);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public CartItem checkExist(int cid, String did) {
		mySQLJDBC.setPreparedSql("select * from cart\r\n" + 
				"where cid = ? and did = ?;", cid, did);
		ResultSet res = mySQLJDBC.excuteQuery();
		try {
			if ((res != null) && (res.next())) {
				CartItem cur = new CartItem(res.getInt("did"), res.getInt("quantity"));
				return cur;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateItem(int cid, String did, int quantity){
		mySQLJDBC.setPreparedSql("update cart set quantity = ?\r\n" + 
				"where cid = ? and did =?;", quantity, cid, did);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public boolean deleteItem(int cid, String did){
		mySQLJDBC.setPreparedSql("delete from cart\r\n" + 
				"where cid = ? and did =?;", cid, did);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public boolean deleteAll(int cid){
		mySQLJDBC.setPreparedSql("delete from cart\r\n" + 
				"where cid = ?;", cid);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
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
