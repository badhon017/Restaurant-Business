package com.restaurantbusiness.store.restaurantbusiness.mapper;

import com.restaurantbusiness.store.restaurantbusiness.domain.Order;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.OrderRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.OrderResponseDTO;

public class OrderMapper {
    public OrderMapper() {
    }
    public static OrderResponseDTO toDto(Order order) {
        return OrderResponseDTO.builder()
                .customerId(order.getCustomerId())
                .foods(order.getFoods())
                .localDate(order.getLocalDate().toString())
                .bill(order.getBill())
                .build();
    }
    public static Order toEntity(OrderRequestDTO dto) {
        Order order = new Order();
        order.setCustomerId(dto.getCustomerId());
        order.setFoods(dto.getFoods());
        order.setLocalDate(dto.getLocalDate());
        order.setBill(dto.getBill());
        return order;
    }
}
