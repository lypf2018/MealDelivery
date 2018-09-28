package domain.bean;

public class Dish {
	private String dishID = null;
	private String name = null;
	private double price = 0;
	private int orderNum = 0;
	
	
	//Get and Set DishID  
	public String getDishID() {
		return this.dishID;
	}
	
	public void setDishID(String ID) {
		this.dishID = ID;
	}
	
	
	//Get and set the name of Dish
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	//Get and Set price for Dish
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	
	//Get and Set OrderNum of Dish
	public int getOrderNum() {
		return this.orderNum;
		
	}
	
	public void setOrderNum(int newNum) {
		this.orderNum = newNum;
	}
	
	
}
