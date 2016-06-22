package vn.java.myPOS.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import vn.java.myPOS.entity.Menu;

public class MenuDAOImpl implements MenuDAO{
	@SessionTarget
	Session session;
    
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> listMenu(String strFind){
		List<Menu> courses = null;
		String sql;
		try {
			if(!strFind.equals("")){
				sql = "from Menu WHERE name LIKE :findname";
				courses = session.createQuery(sql).setParameter("findname","%"+ strFind +"%").list();	
			} else {
				sql = "from Menu";
				courses = session.createQuery(sql).list();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}
	public List<Menu> listMenu(List<String> ids){
		List<Menu> courses = null;
		String sql;
		try {
			if((ids != null) && !ids.isEmpty()){
				sql = "from Menu WHERE id in (:ids)";
				String idss = StringUtils.join(ids,',');
				courses = session.createQuery(sql).setParameter("ids",idss).list();	
			} else {
				sql = "from Menu";
				courses = session.createQuery(sql).list();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}
	@Override
	public void saveMenu(Menu menu) {
		try {
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			menu.setUpdate_user(1);
			menu.setUpdate_time(currentTime);
			//menu.setPrice_extend(0);
			session.saveOrUpdate(menu);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	@Override
	public Menu getMenu(int id){
		Menu menu = null;
		try{
			menu = (Menu)session.get(Menu.class, id);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return menu;
	}
}
