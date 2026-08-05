package com.preetham.hellospringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	    public List<Restaurant> getRestaurantsSortedByRating() {
	        return restaurantRepository.findAll(
	                Sort.by("rating").descending()
	        );
	    }
	    public Page<Restaurant> getRestaurantsByPage(int page) {
	        Pageable pageable = PageRequest.of(page, 3);
	        return restaurantRepository.findAll(pageable);
	    }
	    public List<Restaurant> getRestaurantByName(String name) {
	        return restaurantRepository.findByName(name);
	    }
	    public List<Restaurant> searchRestaurantsByName(String keyword) {
	        return restaurantRepository.findByNameContaining(keyword);
	    }
	    public List<Restaurant> getRestaurantsByRating(double rating) {
	        return restaurantRepository.findByRatingGreaterThan(rating);
	    }
	    public List<Restaurant> getRestaurantsByCityAndRating(String city, double rating) {
	        return restaurantRepository.findByCityAndRatingGreaterThan(city, rating);
	    }
	    public List<Restaurant> getRestaurantsByCityOrName(String city, String name) {
	        return restaurantRepository.findByCityOrName(city, name);
	    }
	    public List<Restaurant> getRestaurantsByRatingLessThan(double rating) {
	        return restaurantRepository.findByRatingLessThan(rating);
	    }
	    public List<Restaurant> getRestaurantsByRatingBetween(double start, double end) {
	        return restaurantRepository.findByRatingBetween(start, end);
	    }
	    public List<Restaurant> getRestaurantsStartingWith(String prefix) {
	        return restaurantRepository.findByNameStartingWith(prefix);
	    }
	    public List<Restaurant> getRestaurantsEndingWith(String suffix) {
	        return restaurantRepository.findByNameEndingWith(suffix);
	    }
    
}