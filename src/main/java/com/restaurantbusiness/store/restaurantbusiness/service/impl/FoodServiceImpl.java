package com.restaurantbusiness.store.restaurantbusiness.service.impl;

import com.restaurantbusiness.store.restaurantbusiness.domain.Food;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.FoodRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.FoodResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.mapper.FoodMapper;
import com.restaurantbusiness.store.restaurantbusiness.repository.FoodRepository;
import com.restaurantbusiness.store.restaurantbusiness.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public FoodResponseDTO save(FoodRequestDTO dto) {
        Food food = foodRepository.save(FoodMapper.toEntity(dto));
        return FoodMapper.toDto(food);
    }

    @Override
    public FoodResponseDTO findById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Food not found with provided id"));
        return FoodMapper.toDto(food);
    }

    @Override
    public FoodResponseDTO updateById(Long id, FoodRequestDTO dto) {
        Food food = foodRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Food not found with provided id"));
        food.setName(dto.getName());
        food.setPrice(dto.getPrice());
        food.setStock(dto.getStock());
        food.setOrder(dto.getOrder());
        return FoodMapper.toDto(foodRepository.save(food));
    }

    @Override
    public List<FoodResponseDTO> findAll() {
        List<Food> foods = foodRepository.findAll();
        return foods.stream().map(FoodMapper::toDto).toList();
    }
}
