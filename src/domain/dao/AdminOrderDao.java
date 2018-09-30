package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.bean.Order;

public class AdminOrderDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public ArrayList<Order> displayOrder(){
		ArrayList<Order> list = new ArrayList<>();
		mySQLJDBC.setPreparedSql("select * from customerorder;","");
		ResultSet resultSet = mySQLJDBC.excuteQuery();
//		response.getWriter().println("hello");
		try {
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderID(resultSet.getString("oid"));
				order.setCustomerID(resultSet.getString("cid"));
				order.setBill(resultSet.getDouble("bill"));
				order.setTime(resultSet.getString("time"));
				order.setStatus(resultSet.getInt("status"));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		AdminOrderDao a = new AdminOrderDao();
		a.displayOrder();
	}
}
