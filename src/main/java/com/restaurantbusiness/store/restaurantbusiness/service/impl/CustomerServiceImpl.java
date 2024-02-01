package com.restaurantbusiness.store.restaurantbusiness.service.impl;

import com.restaurantbusiness.store.restaurantbusiness.domain.Customer;
import com.restaurantbusiness.store.restaurantbusiness.dto.request.CustomerRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.CustomerResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.mapper.CustomerMapper;
import com.restaurantbusiness.store.restaurantbusiness.repository.CustomerRepository;
import com.restaurantbusiness.store.restaurantbusiness.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO dto) {
        Customer customer = customerRepository.save(CustomerMapper.toEntity(dto));
        return CustomerMapper.toDto(customer);
    }

    @Override
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Customer not found with provided id"));
        return CustomerMapper.toDto(customer);
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::toDto).toList();
    }

    @Override
    public CustomerResponseDTO updateById(Long id, CustomerRequestDTO dto) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Customer not found with provided id"));
        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        return CustomerMapper.toDto(customerRepository.save(customer));
    }
}
