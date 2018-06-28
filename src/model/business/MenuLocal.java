package model.business;

import java.util.List;

import javax.ejb.Local;

import model.domain.Menu;

@Local
public interface MenuLocal {
	List<Menu> findMenusByPosition(int position);
}
