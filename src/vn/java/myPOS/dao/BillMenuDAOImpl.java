package vn.java.myPOS.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import vn.java.myPOS.entity.Bill;
import vn.java.myPOS.entity.BillMenu;

public class BillMenuDAOImpl implements BillMenuDAO{
	@SessionTarget
	Session session;
    
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	@Override
	public List<BillMenu> listBillMenu(){
		List<BillMenu> courses = null;
		try {
			courses = session.createQuery("from menu_bill").list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}
	@Override
	public void saveMenuBill(BillMenu billmenu){
		try {
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			billmenu.setCreate_date(currentTime);
			session.save(billmenu);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}

}
