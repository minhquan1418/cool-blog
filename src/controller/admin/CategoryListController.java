package controller.admin;

import java.io.IOException;
import java.util.List;

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
import model.domain.Category;

/**
 * Servlet implementation class CategoriesController
 */
@WebServlet(urlPatterns = "/admin/category-list", initParams = {
		@WebInitParam(name = "contentTitle", value = "Categories"),
		@WebInitParam(name = "contentFilePath", value = "category_list") })
public class CategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryLocal categoryLocal = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryListController() {
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

		// lookup
		try {
			categoryLocal = (CategoryLocal) new InitialContext()
					.lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		// pagination
		String page = request.getParameter("page");
		int pageNumber = (page == null) ? 1 : Integer.parseInt(page);
		int pageSize = 15;
		int pageTotal = (int) Math.ceil((categoryLocal.findAllCategories().size() / (double) pageSize));

		List<Category> categories = categoryLocal.findCategoriesPaginate(pageNumber, pageSize);

		request.setAttribute("categories", categories);
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("pageNumber", pageNumber);

		RequestDispatcher view = request.getRequestDispatcher("layout.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
