package model.business;

import java.util.List;

import javax.ejb.Local;

import model.domain.Article;

@Local
public interface ArticleLocal {
	List<Article> findAllArticles();

	List<Article> findArticlesByIdCategory(int idCategory, int pageNumber, int pageSize);

	List<Article> findArticlesPaginate(int pageNumber, int pageSize);

	List<Article> findArticlesByIdCategoryPaginate(int idCategory);

	Article addArticle(Article article);

	Article findArticleById(int id);

	Article updateArticleById(Article article);

	void deleteArticleById(int id);
}
