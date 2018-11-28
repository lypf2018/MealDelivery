package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

//import domain.bean.Customer;
import domain.bean.Order;
import util.MySQLJDBC;

public class OrderDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public int saveOrder(String cid, String bill){
		Date date = new Date();
		int oid = (int) date.getTime();
		mySQLJDBC.setPreparedSql("insert into customerorder (oid, bill, cid) \n" + 
				"values (?, ?, ?);", oid,bill,cid);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return oid;
		}
		return -1;
	}
	
	public boolean saveOrderDetails(int oid, int did, int amount){
		mySQLJDBC.setPreparedSql("insert into orderdetails (oid, did, amount) \n" + 
				"values (?, ?, ?);", oid, did, amount);
		int res = mySQLJDBC.executeUpdate();
		if (res != -1) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Order> displayOrder(int customerID){
		ArrayList<Order> list = new ArrayList<>();
		mySQLJDBC.setPreparedSql("select * from customerorder where cid=?;", customerID);
		ResultSet resultSet = mySQLJDBC.excuteQuery();
//		response.getWriter().println("hello");
		try {
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderID(resultSet.getString("oid"));
				order.setCustomerID(resultSet.getString("cid"));
				order.setBill(resultSet.getDouble("bill"));
				order.setTime(resultSet.getString("time"));
				order.setStatus(resultSet.getString("status"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();
		
		return list;
	}
	

}
