package vn.java.myPOS.dao;

import java.util.List;

import vn.java.myPOS.entity.Bill;
import vn.java.myPOS.entity.BillMenu;;

public interface BillDAO {
	
	public void saveBill(Bill bill);
	public void saveBillMenu(List<BillMenu> billList);
	public List<vn.java.myPOS.model.BillMenu> listBill(int bill_id);
}
