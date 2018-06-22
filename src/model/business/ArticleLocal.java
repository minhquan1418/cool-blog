package model.business;

import java.util.List;

import javax.ejb.Local;

import model.entities.Article;

@Local
public interface ArticleLocal {
	List<Article> findAllArticles();
	List<Article> findArticlesByIdCategory(int idCategory, int pageNumber, int pageSize);
	List<Article> findArticlesPaginate(int pageNumber, int pageSize);
	Article addArticle(Article article);
	Article findArticleById(int id);
	Article updateArticleById(Article article);
	void deleteArticleById(int id);
}
