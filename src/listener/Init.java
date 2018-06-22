    package listener;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.business.CategoryLocal;
import model.business.MenuLocal;
import model.entities.Category;
import model.entities.Menu;

@WebListener
public class Init implements ServletContextListener {
	private MenuLocal menuLocal = null;
	private CategoryLocal categoryLocal = null;
	
    public Init() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext sc = sce.getServletContext();
    	
    	/* side bar menu in admin view */
    	// model object
    	try {
    		menuLocal = (MenuLocal) new InitialContext().lookup("java:global/cool-blog/MenuBean!model.business.MenuLocal");
    		categoryLocal = (CategoryLocal) new InitialContext().lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
    	} catch (NamingException e) {
			e.printStackTrace();
		}
    	// get data from model
    	List<Menu> adminMenus = menuLocal.findMenusByPosition(1);
    	// add to ServletContext
    	sc.setAttribute("sideBarItems", adminMenus);
    	
    	// default admin view == first adminsidebar found in database table SideBarItems
    	sc.setAttribute("defaultAdminView", adminMenus.get(0));
    	
    	// get data for top menu
    	List<Menu> topMenus = menuLocal.findMenusByPosition(2);
    	sc.setAttribute("topMenus", topMenus);
    	
    	// get categories list
    	List<Category> categoriesList = categoryLocal.findAllCategories();
    	sc.setAttribute("categoriesList", categoriesList);
    } 
	
}
