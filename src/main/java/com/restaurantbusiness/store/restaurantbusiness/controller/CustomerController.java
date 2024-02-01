package com.restaurantbusiness.store.restaurantbusiness.controller;

import com.restaurantbusiness.store.restaurantbusiness.dto.request.CustomerRequestDTO;
import com.restaurantbusiness.store.restaurantbusiness.dto.response.CustomerResponseDTO;
import com.restaurantbusiness.store.restaurantbusiness.service.CustomerService;
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
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO dto) {
        CustomerResponseDTO customerDTO = customerService.save(dto);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable("id") Long id) {
        CustomerResponseDTO customerDTO = customerService.findById(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        List<CustomerResponseDTO> customerList = customerService.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> updateById(@PathVariable("id") Long id,
                                                          @RequestBody CustomerRequestDTO dto) {
        CustomerResponseDTO customerDTO = customerService.updateById(id, dto);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
}
