package domain.bean;

public class CartItem {
	private int did = 0;
	private int quantity = 0;
	private String name = null;
	private double price = 0;
	private int categoryId = 0;
	private String categoryName = null;
			
	public CartItem(int did, int quantity) {
		this.did = did;
		this.quantity = quantity;
	}
	
	public int getId() {
		return did;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
}


