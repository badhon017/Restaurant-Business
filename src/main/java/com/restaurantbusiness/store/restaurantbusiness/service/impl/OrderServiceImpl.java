package com.restaurantbusiness.store.restaurantbusiness.service.impl;

import com.restaurantbusiness.store.restaurantbusiness.domain.Order;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.OrderRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.OrderResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.mapper.OrderMapper;
import com.restaurantbusiness.store.restaurantbusiness.repository.OrderRepository;
import com.restaurantbusiness.store.restaurantbusiness.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    public List<OrderResponseDTO> findAll(LocalDate localDate) {
        List<Order> orders;
        if(Objects.nonNull(localDate)) {
            orders = orderRepository.findAll(localDate);
        } else {
            orders = orderRepository.findAll();
        }
        return orders.stream().map(OrderMapper::toDto).toList();
    }

    @Override
    public List<OrderResponseDTO> findOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findOrderByCustomerId(customerId);
        return orders.stream()
                .map(OrderMapper::toDto).toList();
    }

    @Override
    public Long findTotalSalesCurrentDay() {
        return orderRepository.findTotalSalesOfCurrentDay(LocalDate.now());
    }

    @Override
    public LocalDate findMaxSalesDay(LocalDate fromDate, LocalDate toDate) {
        List<Order> orders = orderRepository.findOrdersBetweenDateRange(fromDate, toDate);
        Long maxSale = 0L;
        LocalDate date = LocalDate.now();
        for (Order order : orders) {
            Long sale = orderRepository.findTotalSalesOfCurrentDay(order.getLocalDate());
            if (sale > maxSale) {
                maxSale = sale;
                date = order.getLocalDate();
            }
        }
        return date;
    }
}