package vn.java.myPOS.dao;

import java.util.List;
import vn.java.myPOS.entity.Menu;

public interface MenuDAO {
	
	public void saveMenu(Menu menu);
	public List<Menu> listMenu(String strFind);
	public List<Menu> listMenu(List<Integer> ids);
	public Menu getMenu(int id);
}
