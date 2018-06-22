package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.CategoryLocal;
import model.entities.Category;

/**
 * Servlet implementation class CategoryUpdateController
 */
@WebServlet(
	urlPatterns = "/admin/category-update", 
	initParams = {
		@WebInitParam(name = "contentTitle", value = "Updating Category"),
		@WebInitParam(name = "contentFilePath", value = "category_update") 
	}
)
public class CategoryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryLocal categoryLocal = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentTitle", getServletConfig().getInitParameter("contentTitle"));
		request.setAttribute("contentFilePath", getServletConfig().getInitParameter("contentFilePath"));

		// get id of the selected category
		int id = Integer.parseInt(request.getParameter("id"));

		// model
		try {
			categoryLocal = (CategoryLocal) new InitialContext().lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// get the selected category
		Category category = categoryLocal.findCategoryById(id);

		// add to request attribute
		request.setAttribute("category", category);

		RequestDispatcher view = request.getRequestDispatcher("layout.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = new Category();
		category.setId(Integer.parseInt(request.getParameter("id")));
		category.setName(request.getParameter("name"));

		// lookup
		try {
			categoryLocal = (CategoryLocal) new InitialContext().lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		// update
		categoryLocal.updateCategoryById(category);
		
		response.sendRedirect("category-update?id=" + request.getParameter("id"));
	}

}
