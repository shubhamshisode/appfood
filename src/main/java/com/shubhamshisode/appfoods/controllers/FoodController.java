package com.shubhamshisode.appfoods.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubhamshisode.appfoods.entity.Food;
import com.shubhamshisode.appfoods.service.FoodService;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "http://localhost:3001")
public class FoodController {

    private final FoodService service;
    

    public FoodController(FoodService service) {
        this.service = service;
    }

    
    @GetMapping
    public List<Food> getAllFoods() {
        return service.getAll();
    }

    
    @GetMapping("/{id}")
    public Food getFood(@PathVariable Long id) {
        return service.getById(id);
    }
    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return service.save(food);
    }

 
    @PutMapping("/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food food) {
        return service.update(id, food);
    }


    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        service.delete(id);
    }
}


