package vn.java.myPOS.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue
	private int id;
	//name of menu
	@Column(name="name")
	private String name;
	//description of menu
	@Column(name="description")
	private String description;
	//price of menu, this is price to set bill for custom
	@Column(name="price")
	private int price;
	//user id create menu
	@Column(name="update_user")
	private int update_user;
	//last time update menu
	@Column(name="update_time")
	private String update_time;
	//price of  option
	@Column(name="price_extend")
	private int price_extend;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(int update_user) {
		this.update_user = update_user;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public int getPrice_extend() {
		return price_extend;
	}
	public void setPrice_extend(int price_extend) {
		this.price_extend = price_extend;
	}

	
}
