package controller.mainpage;

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
import model.entities.Article;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(
	urlPatterns="/category",
	initParams = {			
		@WebInitParam(name = "contentFilePath", value = "category")
	}
)
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleLocal articleLocal = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentFilePath", getServletConfig().getInitParameter("contentFilePath"));
		int idCategory = Integer.parseInt(request.getParameter("id"));
		
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
		
		List<Article> articles = articleLocal.findArticlesByIdCategory(idCategory, pageNumber, pageSize);
		
		request.setAttribute("articles", articles);
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("idCategory", idCategory);
		
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
