package com.preetham.hellospringboot.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preetham.hellospringboot.model.Restaurant;

public interface RestaurantRepository
        extends JpaRepository<Restaurant, Integer> {
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByName(String name);
	List<Restaurant> findByNameContaining(String keyword);
	List<Restaurant> findByRatingGreaterThan(double rating);
	List<Restaurant> findByCityAndRatingGreaterThan(String city, double rating);
	List<Restaurant> findByCityOrName(String city, String name);
	List<Restaurant> findByRatingLessThan(double rating);
	List<Restaurant> findByRatingBetween(double start, double end);
	List<Restaurant> findByNameStartingWith(String prefix);
	List<Restaurant> findByNameEndingWith(String suffix);
	@Query("SELECT r FROM Restaurant r")
	List<Restaurant> getAllRestaurantsCustom();

}
