package com.devstack.orderserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Long customerId;
    private Long productId;
    private Double cost;
}
