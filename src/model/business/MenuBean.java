package model.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import model.domain.Menu;

/**
 * Session Bean implementation class MenuBean
 */
@Stateless
@LocalBean
public class MenuBean implements MenuLocal {
	@PersistenceContext(name = "JPADB")
	private EntityManager em;

	public MenuBean() {
	}

	@Override
	public List<Menu> findMenusByPosition(int position) {
		Query query = em.createQuery("SELECT m FROM Menu m where m.position = :position");
		query.setParameter("position", position);
		List<Menu> menus = query.getResultList();
		return menus;
	}
}
