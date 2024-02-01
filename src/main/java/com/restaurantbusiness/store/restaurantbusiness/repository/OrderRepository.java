package com.restaurantbusiness.store.restaurantbusiness.repository;

import com.restaurantbusiness.store.restaurantbusiness.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
