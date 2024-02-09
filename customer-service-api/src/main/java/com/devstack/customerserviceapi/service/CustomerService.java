package com.devstack.customerserviceapi.service;

import com.devstack.customerserviceapi.dto.CustomerDto;
import com.devstack.customerserviceapi.dto.ResponseCustomerDto;

public interface CustomerService {
    public void createCustomer(CustomerDto dto);
    public ResponseCustomerDto findCustomerById(Long id);
}
