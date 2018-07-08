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
import model.domain.Category;

/**
 * Servlet implementation class CategoryAddController
 */
@WebServlet(urlPatterns = "/admin/category-add", initParams = {
		@WebInitParam(name = "contentTitle", value = "Adding Category"),
		@WebInitParam(name = "contentFilePath", value = "category_add") })
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryLocal categoryLocal = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryAddController() {
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

		RequestDispatcher view = request.getRequestDispatcher("layout.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
		category.setName(request.getParameter("name"));

		// model
		try {
			categoryLocal = (CategoryLocal) new InitialContext()
					.lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		// add category
		categoryLocal.addCategory(category);

		response.sendRedirect("category-list");
	}

}
