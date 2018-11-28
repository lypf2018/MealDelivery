package domain.bean;

public class OrderDetails {
	private int did = 0;
	private int amount = 0;
	private int oid = 0;
			
	public OrderDetails(int did, int amount, int oid) {
		this.did = did;
		this.amount = amount;
		this.oid = oid;
	}
	
	public int getId() {
		return did;
	}
	public int getAmount() {
		return amount;
	}
	public int getOid() {
		return oid;
	}
	
}
