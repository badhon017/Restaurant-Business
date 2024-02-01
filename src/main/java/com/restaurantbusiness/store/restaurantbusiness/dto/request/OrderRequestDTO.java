package com.restaurantbusiness.store.restaurantbusiness.dto.request;

import com.restaurantbusiness.store.restaurantbusiness.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDTO {
    private Long id;

    private Long customerId;

    private List<Food> foods;

    private LocalDate localDate;

    private Long bill;
}
