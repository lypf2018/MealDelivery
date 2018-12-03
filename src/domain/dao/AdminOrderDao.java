package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.bean.Dish;
import domain.bean.Order;

public class AdminOrderDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public ArrayList<Order> displayOrder(){
		ArrayList<Order> list = new ArrayList<>();
		mySQLJDBC.setPreparedSql("select * from customerorder;");
		ResultSet resultSet = mySQLJDBC.excuteQuery();
//		response.getWriter().println("hello");
		try {
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderID(resultSet.getString("oid"));
				order.setCustomerID(resultSet.getString("cid"));
				order.setBill(resultSet.getDouble("bill"));
				order.setTime(resultSet.getString("time"));
				if(resultSet.getInt("status") == 0) {
					order.setStatus("undergoing");
				}
				else {
					order.setStatus("completed");
				}

				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();
		
		return list;
	}
	
	public Order getOrder(String id) {
		Order returnValue = new Order();
		returnValue.setOrderID(id);
//		System.out.println("orderId = "+returnValue.getOrderID());
//		ArrayList<Dish> dishList = new ArrayList<>();
		mySQLJDBC.setPreparedSql("select * from orderdetails, dish where orderdetails.did = dish.did and oid =?;",id);
		ResultSet resultSet = mySQLJDBC.excuteQuery();
//		response.getWriter().println("hello");
		try {
			while(resultSet.next()) {
				Dish dish = new Dish();
				dish.setId(resultSet.getInt("did"));
				dish.setName(resultSet.getString("name"));
				dish.setPrice(resultSet.getDouble("price"));
				dish.setDish_amount(resultSet.getInt("amount"));
//				dishList.add(dish);
				returnValue.setDish(dish);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();

		return returnValue;
	}
	
	public void updateStatus(String s, String orderId) {
		int a = 1;
//		System.out.print("s = " + s);
		if(s.equals("undergoing"))a = 0;
		else a = 1;
		System.out.print("a="+a);
		mySQLJDBC.setPreparedSql("update customerorder set status = ? where oid = ?;",a,orderId);
		mySQLJDBC.executeUpdate();
		mySQLJDBC.close();
//		System.out.print("update status to "+s+" and orderId = "+orderId);
	}
	
	public static void main(String[] args) {
		AdminOrderDao a = new AdminOrderDao();
		a.displayOrder();
	}
}
