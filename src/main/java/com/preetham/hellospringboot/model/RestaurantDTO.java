package com.preetham.hellospringboot.model;

public class RestaurantDTO {

    private String name;
    private double rating;

    public RestaurantDTO(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }
}