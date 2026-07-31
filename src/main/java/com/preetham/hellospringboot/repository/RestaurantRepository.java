package com.preetham.hellospringboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preetham.hellospringboot.model.Restaurant;

public interface RestaurantRepository
        extends JpaRepository<Restaurant, Integer> {
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByName(String name);
	List<Restaurant> findByNameContaining(String keyword);

}
