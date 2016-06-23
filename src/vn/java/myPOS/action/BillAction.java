package vn.java.myPOS.action;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import vn.java.myPOS.dao.BillDAO;
import vn.java.myPOS.dao.BillDAOImpl;
import vn.java.myPOS.dao.BillMenuDAO;
import vn.java.myPOS.dao.BillMenuDAOImpl;
import vn.java.myPOS.dao.MenuDAO;
import vn.java.myPOS.dao.MenuDAOImpl;
import vn.java.myPOS.entity.Bill;
import vn.java.myPOS.entity.BillMenu;
import vn.java.myPOS.entity.Menu;

public class BillAction extends ActionSupport implements ModelDriven<Bill>  {
	private static final long serialVersionUID = -6659925652584240539L;
	private Bill bill = new Bill();
	private List<vn.java.myPOS.model.BillMenu> billList = new ArrayList<vn.java.myPOS.model.BillMenu>();
	public List<vn.java.myPOS.model.BillMenu> getBillList() {
		return billList;
	}

	public void setBillList(List<vn.java.myPOS.model.BillMenu> billList) {
		this.billList = billList;
	}

	public List<Menu> getMenuFilterList() {
		return menuFilterList;
	}

	public void setMenuFilterList(List<Menu> menuFilterList) {
		this.menuFilterList = menuFilterList;
	}

	private List<Menu> menuFilterList = new ArrayList<Menu>();
	private BillDAO billDao = new BillDAOImpl();
	private MenuDAO menuDao = new MenuDAOImpl(); 
	private BillMenuDAO billMenuDao = new BillMenuDAOImpl();
	
	@Override
	public Bill getModel() {
		return bill;
	}
	
	public String add()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		bill.setPost(request.getParameter("id_table"));
		billDao.saveBill(bill);
		billList = billDao.listBill(bill.getId());
		List<Integer> ids = new ArrayList<Integer>();
		if((billList == null) || billList.isEmpty()){
			
		} else {
			for (vn.java.myPOS.model.BillMenu temp_id : billList) {
				ids.add(Integer.valueOf(temp_id.getId()));
			}
		}
		menuFilterList = menuDao.listMenu(ids);
		return SUCCESS;
	}
	
	public String list()
	{
//		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
//		bill.setPost(request.getParameter("id_table"));
//		billList = billDao.listBill();
		return SUCCESS;
	}
	public String savebill(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		String strJson = request.getParameter("strJson");
		//strJson = strJson.substring(1, strJson.length()-1);
		//JSONObject jobj = new JSONObject(strJson);
		//JSONArray menulisttemp = jobj.getJSONArray("");
		Gson gson = new Gson();
		List<vn.java.myPOS.model.BillMenu> listtemp = new ArrayList<vn.java.myPOS.model.BillMenu>();
		listtemp =  gson.fromJson(strJson, new TypeToken<List<vn.java.myPOS.model.BillMenu>>(){}.getType());
		BillMenu billtemp = new BillMenu();
		for(Iterator<vn.java.myPOS.model.BillMenu> i = listtemp.iterator(); i.hasNext(); ) {
			vn.java.myPOS.model.BillMenu item = i.next();
			billtemp = new BillMenu();
			billtemp.setBill_id(item.getBill_id());
			billtemp.setMenu_id(item.getMenu_id());
			billMenuDao.saveMenuBill(billtemp);
		    //System.out.println(item);
		}
		
		return SUCCESS;
	}
		
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
