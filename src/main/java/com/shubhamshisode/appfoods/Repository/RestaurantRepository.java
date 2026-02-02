package com.shubhamshisode.appfoods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shubhamshisode.appfoods.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	  List<Restaurant> findByNameContainingIgnoreCase(String q);
	    List<Restaurant> findByLocationContainingIgnoreCase(String q);
	    List<Restaurant> findByCuisineContainingIgnoreCase(String q);
	}

