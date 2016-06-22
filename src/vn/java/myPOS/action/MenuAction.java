package vn.java.myPOS.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.velocity.components.ActionDirective;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import vn.java.myPOS.dao.MenuDAO;
import vn.java.myPOS.dao.MenuDAOImpl;
import vn.java.myPOS.entity.Menu;

public class MenuAction extends ActionSupport implements ModelDriven<Menu>  {
	private static final long serialVersionUID = -6659925652584240540L;
	private Menu menu = new Menu();
	private String findName=null;
	private String target="";
	private List<Menu> menuList = new ArrayList<Menu>();
	private MenuDAO menuDao = new MenuDAOImpl();
	private String url;

	public String getUrl()
	{
	 return url;
	}
	@Override
	public Menu getModel() {
		return menu;
	}
	public String execute() throws Exception {
		if(this.getTarget().equals("list")){
			return this.list();
		}
		return SUCCESS;

	}
	/***
	 * Get data Menu from ID to edit dsd
	 * @return 
	 */
	public String edit(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		menu = menuDao.getMenu(Integer.parseInt( request.getParameter("id")));
		return SUCCESS;
	}
	public String saveOrUpdate()
	{
		menuDao.saveMenu(menu);
		url = "/updateMenu?id=" + menu.getId();
		return "redirect";		
	}
	
	public String list()
	{
		
		menuList = menuDao.listMenu(this.findName);
		//String json = new Gson().toJson(menuList);
		return SUCCESS;
	}
	public String listall()
	{
		
		menuList = menuDao.listMenu("");
		return SUCCESS;
	}
	public Menu getMenu() {
		return menu;
	}
	//public String get
	public void setmenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getFindName() {
		return findName;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

}
