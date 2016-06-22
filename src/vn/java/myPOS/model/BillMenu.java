package vn.java.myPOS.model;

public class BillMenu {

	private int user_id;

	private int menu_id;

	private int bill_id;
	private int id;

	private int amount;

	private String create_date;
	
	private vn.java.myPOS.entity.Menu menu;
	private vn.java.myPOS.entity.Bill bill;
	
	public vn.java.myPOS.entity.Menu getMenu() {
		return menu;
	}
	public void setMenu(vn.java.myPOS.entity.Menu menu) {
		this.menu = menu;
	}
	public vn.java.myPOS.entity.Bill getBill() {
		return bill;
	}
	public void setBill(vn.java.myPOS.entity.Bill bill) {
		this.bill = bill;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreate_date() {
		return create_date;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
