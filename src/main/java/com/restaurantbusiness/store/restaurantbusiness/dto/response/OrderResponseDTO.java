package com.restaurantbusiness.store.restaurantbusiness.dto.response;

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
public class OrderResponseDTO {

    private Long customerId;

    private List<Food> foods;

    private String localDate;

    private Long bill;
}
