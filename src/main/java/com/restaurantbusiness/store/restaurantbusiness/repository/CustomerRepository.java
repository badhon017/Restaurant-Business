package com.restaurantbusiness.store.restaurantbusiness.repository;

import com.restaurantbusiness.store.restaurantbusiness.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
