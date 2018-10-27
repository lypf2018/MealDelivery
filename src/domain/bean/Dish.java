package domain.bean;

public class Dish {
	// define private attributes
	private int dish_id;
	private String dish_name;
	private String dish_des;
	private String dish_pic;
	private double dish_price;
	private int dish_cat_id;
	
	public Dish() {}
	
	public int getId() {
		return dish_id;
	}
	public String getName() {
		return dish_name;
	}
	public String getDes() {
		return dish_des;
	}
	public String getPic() {
		return dish_pic;
	}
	public double getPrice() {
		return dish_price;
	}
	public int getDCId() {
		return dish_cat_id;
	}
	
	public void setId(int id) {
		this.dish_id = id;
	}
	public void setName(String name) {
		this.dish_name = name;
	}
	public void setDes(String des) {
		this.dish_des = des;
	}
	public void setPic(String pic) {
		this.dish_pic = pic;
	}
	public void setPrice(double price) {
		this.dish_price = price;
	}
	public void setDCId(int dcId) {
		this.dish_cat_id = dcId;
	}
}
