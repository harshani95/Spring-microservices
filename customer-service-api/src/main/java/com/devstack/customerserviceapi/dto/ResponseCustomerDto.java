package com.devstack.customerserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCustomerDto {
    private CustomerDto customerData;
    private ResponseOrderDto orderData;
}
