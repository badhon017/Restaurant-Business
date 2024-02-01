package com.restaurantbusiness.store.restaurantbusiness.service;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.OrderRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.OrderResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

     OrderResponseDTO save(OrderRequestDTO dto);

     OrderResponseDTO findById(Long id);

     OrderResponseDTO updateById(Long id, OrderRequestDTO dto);

     List<OrderResponseDTO> findAll(LocalDate localDate);

     List<OrderResponseDTO> findOrdersByCustomerId(Long customerId);

     Long findTotalSalesCurrentDay();

     LocalDate findMaxSalesDay(LocalDate fromDate, LocalDate toDate);
}
