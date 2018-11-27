package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import domain.bean.Customer;
import domain.bean.Order;
import util.MySQLJDBC;

public class OrderDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
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
