package vn.java.myPOS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill_menu")
public class BillMenu {
	@Column(name="user_id")
	private int user_id;
	@Column(name="menu_id")
	private int menu_id;
	@Column(name="bill_id")
	private int bill_id;
	@Id
	@GeneratedValue
	private int id;
	@Column(name="amount")
	private int amount;
	@Column(name="create_date")
	private String create_date;
	
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
