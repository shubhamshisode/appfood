package com.shubhamshisode.appfoods.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shubhamshisode.appfoods.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

   

}
