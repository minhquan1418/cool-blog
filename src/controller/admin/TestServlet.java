package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.ArticleLocal;
import model.domain.Article;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/debug")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleLocal local = null;
		try {
			local = (ArticleLocal) new InitialContext()
					.lookup("java:global/cool-blog/ArticleBean!model.business.ArticleLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		List<Article> articles = local.findAllArticles();

		for (Article a : articles) {
			System.out.println(a.getId() + " " + a.getCategory().getName());
		}
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
