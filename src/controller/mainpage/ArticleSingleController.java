package controller.mainpage;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.ArticleLocal;
import model.domain.Article;

/**
 * Servlet implementation class ArticleSingleController
 */
@WebServlet(urlPatterns = "/article-single", initParams = @WebInitParam(name = "contentFilePath", value = "article_single"))
public class ArticleSingleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleLocal articleLocal = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleSingleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentFilePath", getServletConfig().getInitParameter("contentFilePath"));

		// lookup
		try {
			articleLocal = (ArticleLocal) new InitialContext()
					.lookup("java:global/cool-blog/ArticleBean!model.business.ArticleLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		// get data for article
		Article article = articleLocal.findArticleById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("article", article);

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
