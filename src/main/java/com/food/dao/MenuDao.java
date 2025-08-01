package com.food.dao;

import java.util.List;

import com.food.models.Menu;
import com.food.models.Restaurant;

public interface MenuDao {
	List<Menu> getAllMenu();
	void addMenu(Menu menu);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	Menu getMenu(int menuId);
}
