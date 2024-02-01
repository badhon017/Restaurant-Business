package com.restaurantbusiness.store.restaurantbusiness.controller;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.FoodRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.FoodResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.service.FoodService;
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
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/foods")
    public ResponseEntity<FoodResponseDTO> createFood(@RequestBody FoodRequestDTO dto) {
        FoodResponseDTO foodDTO = foodService.save(dto);
        return new ResponseEntity<>(foodDTO, HttpStatus.OK);
    }
    @GetMapping("/foods/{id}")
    public ResponseEntity<FoodResponseDTO> findById(@PathVariable("id") Long id) {
        FoodResponseDTO foodDTO = foodService.findById(id);
        return new ResponseEntity<>(foodDTO, HttpStatus.OK);
    }

    @GetMapping("/foods")
    public ResponseEntity<List<FoodResponseDTO>> findAll() {
        List<FoodResponseDTO> foods = foodService.findAll();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PutMapping("/foods/{id}")
    public ResponseEntity<FoodResponseDTO> updateById(@PathVariable("id") Long id,
                                                          @RequestBody FoodRequestDTO dto) {
        FoodResponseDTO foodResponseDTO = foodService.updateById(id, dto);
        return new ResponseEntity<>(foodResponseDTO, HttpStatus.OK);
    }
}
