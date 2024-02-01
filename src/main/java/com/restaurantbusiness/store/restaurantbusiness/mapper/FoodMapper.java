package com.restaurantbusiness.store.restaurantbusiness.mapper;

import com.restaurantbusiness.store.restaurantbusiness.domain.Food;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.FoodRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.FoodResponseDTO;

public class FoodMapper {

    public FoodMapper() {
    }

    public static FoodResponseDTO toDto(Food food) {
        return FoodResponseDTO.builder()
                .name(food.getName())
                .price(food.getPrice())
                .stock(food.getStock())
                .order(food.getOrder())
                .build();
    }
    public static Food toEntity(FoodRequestDTO dto) {
        Food food = new Food();
        food.setName(dto.getName());
        food.setPrice(dto.getPrice());
        food.setStock(dto.getStock());
        food.setOrder(dto.getOrder());
        return food;
    }
}
