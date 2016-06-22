package vn.java.myPOS.dao;

import java.util.List;

import vn.java.myPOS.entity.BillMenu;

public  interface BillMenuDAO {
	public void saveMenuBill(BillMenu billmenu);
	public List<BillMenu> listBillMenu();

}
