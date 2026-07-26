package com.preetham.hellospringboot.controller;
import com.preetham.hellospringboot.service.RestaurantService;

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
    @GetMapping("/{id}")
    public String getRestaurant(@PathVariable int id) {
        return "Restaurant ID : " + id;
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
}