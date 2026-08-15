package com.preetham.hellospringboot.service;


import org.springframework.stereotype.Service;
import com.preetham.hellospringboot.model.RestaurantView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;

import com.preetham.hellospringboot.repository.RestaurantRepository;
import com.preetham.hellospringboot.exception.RestaurantNotFoundException;

import com.preetham.hellospringboot.model.Restaurant;
import com.preetham.hellospringboot.model.RestaurantDTO;
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

	    public Restaurant getRestaurantById(int id) {

	        return restaurantRepository.findById(id)
	                .orElseThrow(() -> new RestaurantNotFoundException(
	                        "Restaurant not found with id: " + id
	                ));
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
	    public List<Restaurant> getAllRestaurantsCustom() {
	        return restaurantRepository.getAllRestaurantsCustom();
	    }
	    public List<Restaurant> getRestaurantByCityCustom(String city) {
	        return restaurantRepository.getRestaurantByCityCustom(city);
	    }
	    public List<Restaurant> getRestaurantByCityAndRatingCustom(String city, double rating) {
	        return restaurantRepository.getRestaurantByCityAndRatingCustom(city, rating);
	    }
	    public List<Restaurant> getRestaurantsSortedByRatingCustom() {
	        return restaurantRepository.getRestaurantsSortedByRatingCustom();
	    }
	    public List<Restaurant> getRestaurantsSortedByRatingAscending() {
	        return restaurantRepository.getRestaurantsSortedByRatingAscending();
	    }
	    public List<Restaurant> getRestaurantsByCitySortedByRating(String city) {
	        return restaurantRepository.getRestaurantsByCitySortedByRating(city);
	    }
	    public List<RestaurantDTO> getRestaurantNameAndRating() {
	        return restaurantRepository.getRestaurantNameAndRating();
	    }
	    public List<RestaurantView> getRestaurantNameAndRatingView() {
	        return restaurantRepository.getRestaurantNameAndRatingView();
	    }
}