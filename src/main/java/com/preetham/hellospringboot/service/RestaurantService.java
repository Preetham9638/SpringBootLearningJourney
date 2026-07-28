package com.preetham.hellospringboot.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.preetham.hellospringboot.repository.RestaurantRepository;

import com.preetham.hellospringboot.model.Restaurant;

@Service
public class RestaurantService {
	 private final RestaurantRepository restaurantRepository;
	    public RestaurantService(RestaurantRepository restaurantRepository) {
	        this.restaurantRepository = restaurantRepository;
	    }

	    public Restaurant getRestaurantDetails() {

	        return new Restaurant(
	                101,
	                "Pizza Palace",
	                "Bangalore",
	                4.5);

	    }
	    public Restaurant addRestaurant() {

	        Restaurant restaurant =
	                new Restaurant("Pizza Palace",
	                               "Bangalore",
	                               4.5);

	        return restaurantRepository.save(restaurant);
	    }
	    public List<Restaurant> getAllRestaurants() {
	        return restaurantRepository.findAll();
	    }

	    public Optional<Restaurant> getRestaurantById(int id) {
	        return restaurantRepository.findById(id);
	    }
	    public List<Restaurant> getRestaurantByCity(String city) {
	        return restaurantRepository.findByCity(city);
	    }
    
}