package domain.bean;

public class Category {
	private int category_id;
	private String category_name;
	private String category_des;
	
	public Category() {}
	
	public void setId(int id) {
		this.category_id = id;
	}
	public void setName(String name) {
		this.category_name = name;
	}
	public void setDes(String des) {
		this.category_des = des;
	}
	
	public int getId() {
		return this.category_id;
	}
	public String getName() {
		return category_name;
	}
	public String getDes() {
		return category_des;
	}
}
