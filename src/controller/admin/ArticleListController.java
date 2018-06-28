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

import model.business.ArticleLocal;
import model.domain.Article;

/**
 * Servlet implementation class ArticlesController
 */
@WebServlet(
	urlPatterns = "/admin/article-list",
	initParams = {
		@WebInitParam(name = "contentTitle", value = "Articles"),
		@WebInitParam(name = "contentFilePath", value = "article_list")
	}
)
public class ArticleListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleLocal articleLocal = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentTitle", getServletConfig().getInitParameter("contentTitle"));
		request.setAttribute("contentFilePath", getServletConfig().getInitParameter("contentFilePath"));
				
		// lookup
		try {
			articleLocal = (ArticleLocal) new InitialContext().lookup("java:global/cool-blog/ArticleBean!model.business.ArticleLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		// pagination
		String page = request.getParameter("page");
		int pageNumber = (page == null) ? 1 : Integer.parseInt(page);
		int pageSize = 3;
		int pageTotal = (int) Math.ceil((articleLocal.findAllArticles().size() / (double) pageSize));
		
		List<Article> articles = articleLocal.findArticlesPaginate(pageNumber, pageSize);
		
		request.setAttribute("articles", articles);
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("pageNumber", pageNumber);
		
		RequestDispatcher view = request.getRequestDispatcher("layout.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
