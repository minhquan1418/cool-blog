package model.business;

import java.util.List;

import javax.ejb.Local;

import model.entities.Category;

@Local
public interface CategoryLocal {
	List<Category> findAllCategories();
	List<Category> findCategoriesPaginate(int pageNumber, int pageSize);
	Category findCategoryById(int id);
	Category updateCategoryById(Category category);
	Category addCategory(Category category);
	void deleteCategoryById(int id);
}