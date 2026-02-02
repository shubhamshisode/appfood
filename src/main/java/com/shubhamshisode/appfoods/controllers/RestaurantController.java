package com.shubhamshisode.appfoods.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shubhamshisode.appfoods.entity.Restaurant;
import com.shubhamshisode.appfoods.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant")
@CrossOrigin(origins = "http://localhost:3001")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
        return service.save(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(
            @PathVariable Long id,
            @RequestBody Restaurant restaurant) {
        return service.update(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        service.delete(id);
    }
}
