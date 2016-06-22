package vn.java.myPOS.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import vn.java.myPOS.dao.BillDAO;
import vn.java.myPOS.dao.BillDAOImpl;
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
		List<String> ids = null;
		if((billList == null) || billList.isEmpty()){
			
		} else {
			for (vn.java.myPOS.model.BillMenu temp_id : billList) {
				ids.add(String.valueOf(temp_id.getId()));
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
		
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
