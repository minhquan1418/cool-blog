package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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

import model.business.ArticleLocal;
import model.business.CategoryLocal;
import model.entities.Article;
import model.entities.Category;

/**
 * Servlet implementation class ArticleAddControlller
 */
@WebServlet(
	urlPatterns = "/admin/article-add",
	initParams = {
		@WebInitParam(name = "contentTitle", value = "Adding Article"),
		@WebInitParam(name = "contentFilePath", value = "article_add")
	}
)
public class ArticleAddControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleLocal articleLocal = null;
	private CategoryLocal categoryLocal = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleAddControlller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentTitle", getServletConfig().getInitParameter("contentTitle"));
		request.setAttribute("contentFilePath", getServletConfig().getInitParameter("contentFilePath"));
		
		// category model
		try {
			categoryLocal = (CategoryLocal) new InitialContext().lookup("java:global/cool-blog/CategoryBean!model.business.CategoryLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		List<Category> categories = categoryLocal.findAllCategories();
		// add to attribute
		request.setAttribute("categories", categories);
		

		RequestDispatcher view = request.getRequestDispatcher("layout.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article();
		article.setName(request.getParameter("name"));
		article.setContent(request.getParameter("content"));
		article.setCategory(new Category(request.getParameter("idCategory")));
		article.setCreationTime(new Date());

		// model
		try {
			articleLocal = (ArticleLocal) new InitialContext().lookup("java:global/cool-blog/ArticleBean!model.business.ArticleLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		// add article
		articleLocal.addArticle(article);

		response.sendRedirect("article-list");
	}

}
