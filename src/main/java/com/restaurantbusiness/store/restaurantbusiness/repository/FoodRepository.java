package com.restaurantbusiness.store.restaurantbusiness.repository;

import com.restaurantbusiness.store.restaurantbusiness.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
