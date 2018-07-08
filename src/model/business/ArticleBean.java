package model.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.domain.Article;

/**
 * Session Bean implementation class ArticleBean
 */
@Stateless
@LocalBean
public class ArticleBean implements ArticleLocal {

	@PersistenceContext(name = "JPADB")
	private EntityManager em;

	public ArticleBean() {
	}

	@Override
	public List<Article> findAllArticles() {
		Query query = em.createQuery("SELECT a FROM Article a ORDER BY a.creationTime DESC");
		List<Article> articles = query.getResultList();
		return articles;
	}

	@Override
	public List<Article> findArticlesByIdCategory(int idCategory, int pageNumber, int pageSize) {
		Query query = em
				.createQuery("SELECT a FROM Article a WHERE a.category.id = :idCategory ORDER BY a.creationTime DESC");
		query.setParameter("idCategory", idCategory);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Article> articles = query.getResultList();
		return articles;
	}

	@Override
	public List<Article> findArticlesByIdCategoryPaginate(int idCategory) {
		Query query = em.createQuery("SELECT a FROM Article a WHERE a.category.id = :idCategory");
		query.setParameter("idCategory", idCategory);
		List<Article> articles = query.getResultList();
		return articles;
	}

	@Override
	public Article findArticleById(int id) {
		Article article = em.find(Article.class, id);
		return article;
	}

	@Override
	public Article updateArticleById(Article article) {
		em.merge(article);
		return article;
	}

	@Override
	public void deleteArticleById(int id) {
		Article article = findArticleById(id);
		em.remove(article);
		return;
	}

	@Override
	public Article addArticle(Article article) {
		em.persist(article);
		return article;
	}

	@Override
	public List<Article> findArticlesPaginate(int pageNumber, int pageSize) {
		Query query = em.createQuery("SELECT a FROM Article a ORDER BY a.creationTime DESC");
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Article> articles = query.getResultList();
		return articles;

	}

}
