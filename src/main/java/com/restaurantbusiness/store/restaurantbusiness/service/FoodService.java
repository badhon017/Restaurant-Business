package com.restaurantbusiness.store.restaurantbusiness.service;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.FoodRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.FoodResponseDTO;

import java.util.List;

public interface FoodService {

    FoodResponseDTO save(FoodRequestDTO dto);

    FoodResponseDTO findById(Long id);

    FoodResponseDTO updateById(Long id, FoodRequestDTO dto);

    List<FoodResponseDTO> findAll();
}
