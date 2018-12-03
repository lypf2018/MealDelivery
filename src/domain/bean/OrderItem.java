package domain.bean;

public class OrderItem {
	private int did = 0;
	private int quantity = 0;
	private String name = null;
	private double price = 0;
	private String image = null;
	private String desc = null;
			
	public OrderItem(int did, int quantity) {
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
	
	public double getTotal() {
		double total = this.price * this.quantity;
		return total;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	/*public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}*/
}


