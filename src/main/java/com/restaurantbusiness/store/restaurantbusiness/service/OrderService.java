package com.restaurantbusiness.store.restaurantbusiness.service;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.FoodRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.OrderRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.FoodResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderService {

     OrderResponseDTO save(OrderRequestDTO dto);

     OrderResponseDTO findById(Long id);

     OrderResponseDTO updateById(Long id, OrderRequestDTO dto);

     List<OrderResponseDTO> findAll();
}
