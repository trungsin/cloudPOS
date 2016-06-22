package vn.java.myPOS.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill implements Cloneable{
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	@Id
	@GeneratedValue
	private int id;
	
	//user id enter bill
	@Column(name="user_id")
	private int user_id;
	//date create bill
	@Column(name="create_date")
	private String create_date;
	//last time update bill
	@Column(name="update_date")
	private String update_date;
	//% discount of bill
	@Column(name="discount")
	private int discount;
	//post table
	@Column(name="post")
	private String post;
	//total money bill
	@Column(name="total")
	private int total;
	
	@Column(name="status")
	
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
