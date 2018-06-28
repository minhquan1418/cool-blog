package model.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.domain.Category;

/**
 * Session Bean implementation class CategoryBean
 */
@Stateless
@LocalBean
public class CategoryBean implements CategoryLocal {
	
	@PersistenceContext(unitName = "JPADB")
    private EntityManager em;
	
    public CategoryBean() {
    }

	@Override
	public Category findCategoryById(int id) {
		Category d = em.find(Category.class, id);
		return d;
	}

	@Override
	public List<Category> findAllCategories() {
		Query query = em.createQuery("SELECT c FROM Category c");
		List<Category> categories = query.getResultList();
		return categories;
	}

	@Override
	public Category updateCategoryById(Category category) {
		Category result = findCategoryById(category.getId());
		result.setName(category.getName());
		return result;
	}

	@Override
	public Category addCategory(Category category) {
		category.setNumberOfArticles(0);
		
		em.persist(category);
		return category;
	}

	@Override
	public void deleteCategoryById(int id) {
		Category category = findCategoryById(id);
		em.remove(category);
		return;
	}

	@Override
	public List<Category> findCategoriesPaginate(int pageNumber, int pageSize) {
		Query query = em.createQuery("SELECT c FROM Category c");
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Category> categories = query.getResultList();
		return categories;
	}
}
