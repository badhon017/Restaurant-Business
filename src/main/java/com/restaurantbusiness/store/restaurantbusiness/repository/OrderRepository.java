package com.restaurantbusiness.store.restaurantbusiness.repository;

import com.restaurantbusiness.store.restaurantbusiness.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByCustomerId(Long customerId);

    @Query(value = "select o from Order o where o.localDate =: localDate")
    List<Order> findAll(LocalDate localDate);

    @Query(value = "select sum(o.bill) from Order o where o.localDate =: localDate")
    Long findTotalSalesOfCurrentDay(LocalDate localDate);
    @Query(value = "select o from Order o where o.localDate between :fromDate and :toDate ")
    List<Order> findOrdersBetweenDateRange(LocalDate fromDate, LocalDate toDate);


}
