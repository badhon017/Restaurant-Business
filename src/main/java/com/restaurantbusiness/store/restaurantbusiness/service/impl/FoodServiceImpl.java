package com.restaurantbusiness.store.restaurantbusiness.service.impl;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.FoodRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.FoodResponseDTO;
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
        return null;
    }

    @Override
    public FoodResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public FoodResponseDTO updateById(Long id, FoodRequestDTO dto) {
        return null;
    }

    @Override
    public List<FoodResponseDTO> findAll() {
        return null;
    }
}
