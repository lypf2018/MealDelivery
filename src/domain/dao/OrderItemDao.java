package domain.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.MySQLJDBC;
import domain.bean.*;


public class OrderItemDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	
	
	public ArrayList<OrderItem> getOrderDishes(int Oid) {
		mySQLJDBC.setPreparedSql("select * from \r\n" + 
				"orderdetails join dish on\r\n" + 
				"orderdetails.did = dish.did\r\n" + 
				"where orderdetails.oid = ?;", Oid);
		ResultSet res = mySQLJDBC.excuteQuery();
		ArrayList<OrderItem> items = new ArrayList<>();
		try {
			while ((res != null) && (res.next())) {
				OrderItem cur = new OrderItem(res.getInt("did"), res.getInt("amount"));
				cur.setName(res.getString("name"));
				cur.setImage(res.getString("picture"));
				cur.setDesc(res.getString("description"));
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

