package domain.bean;

import java.util.LinkedList;
import domain.bean.Dish;

public class Order {
	private String orderID = null;
	private String customerID = null;
	private LinkedList<Dish> dish = null;
	private String time = null;
	private int status = 0;
	private double bill = 0;
	
//	public Order() {
//		orderID = null;
//		String customerID = null;
//		LinkedList<String> dish = new LinkedList<>();
//		String time = null;
//		int status = 0;
//	}
	
	//getter and setter for orderID
	public String getOrderID() {
		return orderID;
	}
	
	public void setOrderID(String ID) {
		this.orderID = ID;
	}
	
	
	//getter and setter for customerID
		public String getCustomerID() {
			return customerID;
		}
		
		public void setCustomerID(String ID) {
			this.customerID = ID;
		}
	
	
	//getter and setter for dish
	public LinkedList<Dish> getDish() {
		return dish;
	}
	
	public void setDish(Dish d) {
		dish.add(d);
	}
	
	
	
    //getter and setter for time
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
    //getter and setter for status
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int s) {
		this.status = s;
	}
	
	
	//getter and setter for bill
		public double getBill() {
//			for(Dish d : dish) {
//				int dishNum = d.getOrderNum();
//				double dishPrice = d.getPrice();
//				bill += dishNum * dishPrice;
//			}
			return bill;
		}
		
		public void setBill(double b) {
			this.bill = b;
		}
		
		
	
}
