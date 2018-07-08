package controller.mainpage;

import java.io.IOException;

import javax.ejb.EJB;
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

	@EJB
	private ArticleLocal articleLocal;

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
