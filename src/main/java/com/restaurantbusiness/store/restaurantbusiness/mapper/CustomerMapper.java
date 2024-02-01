package com.restaurantbusiness.store.restaurantbusiness.mapper;

import com.restaurantbusiness.store.restaurantbusiness.domain.Customer;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.CustomerRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.CustomerResponseDTO;

public class CustomerMapper {

    public CustomerMapper() {
    }

    public static CustomerResponseDTO toDto(Customer customer) {
        return CustomerResponseDTO.builder()
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .name(customer.getName())
                .build();
    }

    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        return customer;
    }
}
