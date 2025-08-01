package com.food.dao;
import java.util.List;

import com.food.models.*;

public interface RestaurantDao {
	List<Restaurant> getAllRestuarant();
	void addRestaurant(Restaurant restuarant);
	void updateRestaurant(Restaurant restuarant);
	void deleteRestaurant(int restuarantId);
	Restaurant getRestaurant(int restuarantId);
}
