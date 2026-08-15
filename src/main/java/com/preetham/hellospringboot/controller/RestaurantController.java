package com.preetham.hellospringboot.controller;
import com.preetham.hellospringboot.service.RestaurantService;
import com.preetham.hellospringboot.model.RestaurantDTO;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.preetham.hellospringboot.model.Restaurant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import com.preetham.hellospringboot.model.RestaurantView;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @GetMapping("/menu")
    public String menu() {
        return "Welcome to Restaurant Menu";
    }

    @GetMapping("/orders")
    public String orders() {
        return "Restaurant Orders";
    }
   
    @GetMapping("/search")
    public String searchRestaurant(@RequestParam String city) {
        return "Searching restaurants in " + city;
    }
    @GetMapping("/details")
    public ResponseEntity<Restaurant> getRestaurantDetails() {

        Restaurant restaurant = restaurantService.getRestaurantDetails();

        return ResponseEntity.ok(restaurant);

    }
    @PostMapping
    public Restaurant addRestaurant() {
        return restaurantService.addRestaurant();
    }
   
    
    @PostMapping("/add")
    public String addRestaurant(@RequestBody Restaurant restaurant) {

        return "Restaurant Added : " + restaurant.getName();
    }
    @PutMapping("/update")
    public String updateRestaurant(@RequestBody Restaurant restaurant) {

        return "Restaurant Updated : " + restaurant.getName();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable int id) {
        return "Restaurant Deleted Successfully. ID: " + id;
    }
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return restaurantService.getRestaurantById(id);
    }
    @GetMapping("/city/{city}")
    public List<Restaurant> getRestaurantByCity(@PathVariable String city) {
        return restaurantService.getRestaurantByCity(city);
    }
    @GetMapping("/sort/rating")
    public List<Restaurant> getRestaurantsSortedByRating() {
        return restaurantService.getRestaurantsSortedByRating();
    }
    
    @GetMapping("/page/{page}")
    public Page<Restaurant> getRestaurantsByPage(@PathVariable int page) {
        return restaurantService.getRestaurantsByPage(page);
    }
    @GetMapping("/name/{name}")
    public List<Restaurant> getRestaurantByName(@PathVariable String name) {
        return restaurantService.getRestaurantByName(name);
    }
    @GetMapping("/search/{keyword}")
    public List<Restaurant> searchRestaurantsByName(@PathVariable String keyword) {
        return restaurantService.searchRestaurantsByName(keyword);
    }

    @GetMapping("/rating/{rating}")
    public List<Restaurant> getRestaurantsByRating(@PathVariable double rating) {
        return restaurantService.getRestaurantsByRating(rating);
    }
    @GetMapping("/city/{city}/rating/{rating}")
    public List<Restaurant> getRestaurantsByCityAndRating(
            @PathVariable String city,
            @PathVariable double rating) {

        return restaurantService.getRestaurantsByCityAndRating(city, rating);
    }
    @GetMapping("/city/{city}/name/{name}")
    public List<Restaurant> getRestaurantsByCityOrName(
            @PathVariable String city,
            @PathVariable String name) {

        return restaurantService.getRestaurantsByCityOrName(city, name);
    }
    @GetMapping("/rating/less/{rating}")
    public List<Restaurant> getRestaurantsByRatingLessThan(@PathVariable double rating) {
        return restaurantService.getRestaurantsByRatingLessThan(rating);
    }
    @GetMapping("/rating/between/{start}/{end}")
    public List<Restaurant> getRestaurantsByRatingBetween(
            @PathVariable double start,
            @PathVariable double end) {

        return restaurantService.getRestaurantsByRatingBetween(start, end);
    }
    @GetMapping("/name/starts/{prefix}")
    public List<Restaurant> getRestaurantsStartingWith(
            @PathVariable String prefix) {

        return restaurantService.getRestaurantsStartingWith(prefix);
    }
    @GetMapping("/name/ends/{suffix}")
    public List<Restaurant> getRestaurantsEndingWith(
            @PathVariable String suffix) {

        return restaurantService.getRestaurantsEndingWith(suffix);
    }
    @GetMapping("/custom")
    public List<Restaurant> getAllRestaurantsCustom() {
        return restaurantService.getAllRestaurantsCustom();
    }
    @GetMapping("/custom/city/{city}")
    public List<Restaurant> getRestaurantByCityCustom(@PathVariable String city) {
        return restaurantService.getRestaurantByCityCustom(city);
    }
    @GetMapping("/custom/{city}/{rating}")
    public List<Restaurant> getRestaurantByCityAndRatingCustom(
            @PathVariable String city,
            @PathVariable double rating) {

        return restaurantService.getRestaurantByCityAndRatingCustom(city, rating);
    }
    @GetMapping("/custom/sort/rating")
    public List<Restaurant> getRestaurantsSortedByRatingCustom() {
        return restaurantService.getRestaurantsSortedByRatingCustom();
    }
    @GetMapping("/custom/sort/rating/asc")
    public List<Restaurant> getRestaurantsSortedByRatingAscending() {
        return restaurantService.getRestaurantsSortedByRatingAscending();
    }
    @GetMapping("/custom/city/sort/{city}")
    public List<Restaurant> getRestaurantsByCitySortedByRating(
            @PathVariable String city) {

        return restaurantService.getRestaurantsByCitySortedByRating(city);
    }
    @GetMapping("/custom/name-rating")
    public List<RestaurantDTO> getRestaurantNameAndRating() {
        return restaurantService.getRestaurantNameAndRating();
    }
    @GetMapping("/custom/name-rating-view")
    public List<RestaurantView> getRestaurantNameAndRatingView() {
        return restaurantService.getRestaurantNameAndRatingView();
    }
}