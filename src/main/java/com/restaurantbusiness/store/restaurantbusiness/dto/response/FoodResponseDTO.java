package com.restaurantbusiness.store.restaurantbusiness.dto.response;

import com.restaurantbusiness.store.restaurantbusiness.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodResponseDTO {

    private String name;

    private Long price;

    private Long stock;

    private Order order;
}
