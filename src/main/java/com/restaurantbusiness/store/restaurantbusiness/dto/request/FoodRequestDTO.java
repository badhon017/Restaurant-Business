package com.restaurantbusiness.store.restaurantbusiness.dto.request;

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
public class FoodRequestDTO {

    private Long id;

    private String name;

    private Long price;

    private Long stock;
}
