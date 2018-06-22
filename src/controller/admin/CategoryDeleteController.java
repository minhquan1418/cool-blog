package controller.admin;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.CategoryLocal;

/**
 * Servlet implementation class CategoryDeleteController
 */
@WebServlet(urlPatterns = "/admin/category-delete")
public class CategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryLocal categoryLocal = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lookup
		try {
			categoryLocal = (CategoryLocal) new InitialContext().lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		// delete category
		categoryLocal.deleteCategoryById(Integer.parseInt(request.getParameter("id")));
		
		// send redirect
		response.sendRedirect("category-list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
