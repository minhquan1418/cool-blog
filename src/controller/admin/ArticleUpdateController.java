package controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
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
import model.business.CategoryLocal;
import model.domain.Article;
import model.domain.Category;

/**
 * Servlet implementation class ArticleUpdateController
 */
@WebServlet(urlPatterns = "/admin/article-update", initParams = {
		@WebInitParam(name = "contentTitle", value = "Updating Article"),
		@WebInitParam(name = "contentFilePath", value = "article_update") })
public class ArticleUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ArticleLocal articleLocal;
	@EJB
	private CategoryLocal categoryLocal;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleUpdateController() {
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

		// get the selected article
		Article article = articleLocal.findArticleById(Integer.parseInt(request.getParameter("id")));
		// set request attribute
		request.setAttribute("article", article);

		// get all categories
		List<Category> categories = categoryLocal.findAllCategories();
		request.setAttribute("categories", categories);

		RequestDispatcher view = request.getRequestDispatcher("layout.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Article article = new Article();
		article.setId(Integer.parseInt(request.getParameter("id")));
		article.setName(request.getParameter("name"));
		article.setContent(request.getParameter("content"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			article.setCreationTime(df.parse(request.getParameter("creationTime")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Category category = categoryLocal.findCategoryById(Integer.parseInt(request.getParameter("idCategory")));
		article.setCategory(category);

		// update article
		articleLocal.updateArticleById(article);

		// redirect
		response.sendRedirect("article-update?id=" + request.getParameter("id"));
	}

}
