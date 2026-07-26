package com.preetham.hellospringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String city;
    private double rating;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String city, double rating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getRating() {
        return rating;
    }
    public Restaurant(String name, String city, double rating) {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }
}