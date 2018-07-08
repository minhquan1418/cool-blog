package controller.admin;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.ArticleLocal;
import model.business.CategoryLocal;

/**
 * Servlet implementation class ArticleDeleteController
 */
@WebServlet("/admin/article-delete")
public class ArticleDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleLocal articleLocal = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lookup
		try {
			articleLocal = (ArticleLocal) new InitialContext()
					.lookup("java:global/cool-blog/ArticleBean!model.business.ArticleLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		// delete category
		articleLocal.deleteArticleById(Integer.parseInt(request.getParameter("id")));

		// send redirect
		response.sendRedirect("article-list");
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
