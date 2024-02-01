package com.restaurantbusiness.store.restaurantbusiness.service.impl;

import com.restaurantbusiness.store.restaurantbusiness.domain.Order;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.OrderRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.OrderResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.mapper.OrderMapper;
import com.restaurantbusiness.store.restaurantbusiness.repository.OrderRepository;
import com.restaurantbusiness.store.restaurantbusiness.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDTO save(OrderRequestDTO dto) {
        Order order = orderRepository.save(OrderMapper.toEntity(dto));
        return OrderMapper.toDto(order);
    }

    @Override
    public OrderResponseDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Order not found with provided id"));
        return OrderMapper.toDto(order);
    }

    @Override
    public OrderResponseDTO updateById(Long id, OrderRequestDTO dto) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Order not found with provided id"));
        order.setCustomerId(dto.getCustomerId());
        order.setLocalDate(dto.getLocalDate());
        order.setBill(dto.getBill());
        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public List<OrderResponseDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderMapper::toDto).toList();
    }
}
