package com.restaurantbusiness.store.restaurantbusiness.controller;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.OrderRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.OrderResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO dto) {
        OrderResponseDTO orderDTO = orderService.save(dto);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable("id") Long id) {
        OrderResponseDTO orderDTO = orderService.findById(id);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        List<OrderResponseDTO> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDTO> updateById(@PathVariable("id") Long id,
                                                          @RequestBody OrderRequestDTO dto) {
        OrderResponseDTO orderDTO = orderService.updateById(id, dto);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }
}
