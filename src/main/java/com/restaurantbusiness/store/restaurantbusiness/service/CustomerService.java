package com.restaurantbusiness.store.restaurantbusiness.service;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.CustomerRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO save(CustomerRequestDTO dto);

    CustomerResponseDTO findById(Long id);

    List<CustomerResponseDTO> findAll();

    CustomerResponseDTO updateById(Long id, CustomerRequestDTO dto);
}
