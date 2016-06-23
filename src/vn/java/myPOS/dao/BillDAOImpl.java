package vn.java.myPOS.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import vn.java.myPOS.entity.Bill;
import vn.java.myPOS.entity.BillMenu;
import vn.java.myPOS.entity.Menu;

public class BillDAOImpl implements BillDAO{
	@SessionTarget
	Session session;
    
	@TransactionTarget
	Transaction transaction;
	
	@SuppressWarnings("rawtypes")
	Iterator listbill = null;
	Criteria criteria;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<vn.java.myPOS.model.BillMenu> listBill(int bill_id){
		List<vn.java.myPOS.model.BillMenu> courses = new ArrayList<vn.java.myPOS.model.BillMenu>();
		try {
			String sql ="from BillMenu WHERE bill_id =:bill_id";
			listbill = session.createQuery(sql).setParameter("bill_id",bill_id).list().iterator();
			BillMenu bill;
			vn.java.myPOS.model.BillMenu modelBill = new vn.java.myPOS.model.BillMenu();
			Bill b;
			Menu m;
			while ( listbill.hasNext() ) {
				bill = (BillMenu)listbill.next();
				modelBill = new vn.java.myPOS.model.BillMenu();
				modelBill.setCreate_date(bill.getCreate_date());
				modelBill.setBill_id(bill.getBill_id());
				modelBill.setId(bill.getId());
				modelBill.setMenu_id(bill.getUser_id());
				modelBill.setUser_id(bill.getUser_id());
				criteria = session.createCriteria(Bill.class);
				criteria.add(Restrictions.eq("id", bill.getBill_id()));
				b = (Bill)criteria.uniqueResult();
				if(b!=null)
					modelBill.setBill(b);
				
				criteria = session.createCriteria(Menu.class);
				criteria.add(Restrictions.eq("id", bill.getMenu_id()));
				m = (Menu)criteria.uniqueResult();
				if(m!=null)
					modelBill.setMenu(m);
				courses.add(modelBill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return courses;
	}
	@Override
	public void saveBill(Bill bill) {
		try {
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Bill tempBill = bill;
			criteria = session.createCriteria(Bill.class);
			criteria.add(Restrictions.eq("status", "open"))
					.add(Restrictions.eq("post", bill.getPost()));
			tempBill = (Bill)criteria.uniqueResult();
			String currentTime = sdf.format(dt);
			if(tempBill != null){
				bill.setCreate_date(tempBill.getCreate_date());
				bill.setUser_id(tempBill.getUser_id());
				bill.setTotal(tempBill.getTotal());
				bill.setStatus(tempBill.getStatus());
				bill.setId(tempBill.getId());
				bill.setUpdate_date(currentTime);
				tempBill.setUpdate_date(currentTime);
				session.saveOrUpdate(tempBill);				
			} else {
				bill.setCreate_date(currentTime);
				bill.setUpdate_date(currentTime);
				bill.setUser_id(1);
				bill.setTotal(0);
				bill.setStatus("open");
				bill.setUpdate_date(currentTime);
				session.saveOrUpdate(bill);				

			}
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	@Override
	public void saveBillMenu(List<BillMenu> billList){
		for (BillMenu billMenu : billList) {
			session.saveOrUpdate(billMenu);
		}
	}

}
