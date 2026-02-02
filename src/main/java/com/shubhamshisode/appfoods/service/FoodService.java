package com.shubhamshisode.appfoods.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubhamshisode.appfoods.Repository.FoodRepository;
import com.shubhamshisode.appfoods.entity.Food;

@Service
public class FoodService {
	
	
	    private final FoodRepository repo;

	    public FoodService(FoodRepository repo) {
	        this.repo = repo;
	    }

	   
	    public List<Food> getAll() {
	        return repo.findAll();
	    }

	   
	    public Food getById(Long id) {
	        return repo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
	    }

	    
	    public Food save(Food food) {
	        return repo.save(food);
	    }

	    
	    public Food update(Long id, Food food) {
	        Food existing = getById(id);

	        existing.setCustomerName(food.getCustomerName());
	        existing.setFoodName(food.getFoodName());
	        existing.setQuantity(food.getQuantity());
	        existing.setImageUrl(food.getImageUrl());

	        return repo.save(existing);
	    }

	
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	}


