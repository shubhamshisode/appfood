package com.shubhamshisode.appfoods.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubhamshisode.appfoods.entity.Restaurant;
import com.shubhamshisode.appfoods.Repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository repo;

    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    public List<Restaurant> getAll() {
        return repo.findAll();
    }

    public Restaurant getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
    }

    public Restaurant save(Restaurant restaurant) {
        return repo.save(restaurant);
    }

    public Restaurant update(Long id, Restaurant restaurant) {
        Restaurant existing = getById(id);
        existing.setName(restaurant.getName());
        existing.setLocation(restaurant.getLocation());
        existing.setCuisine(restaurant.getCuisine());
        existing.setRating(restaurant.getRating());
        existing.setImageUrl(restaurant.getImageUrl());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
