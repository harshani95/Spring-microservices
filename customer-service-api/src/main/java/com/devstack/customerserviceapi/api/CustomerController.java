package com.devstack.customerserviceapi.api;

import com.devstack.customerserviceapi.dto.CustomerDto;
import com.devstack.customerserviceapi.service.CustomerService;
import com.devstack.customerserviceapi.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/customers")
@RestController

public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponseEntity> createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"customer saved!",customerDto),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<StandardResponseEntity> findCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(
                new StandardResponseEntity(200,"customer saved!",customerService.findCustomerById(id)),
                HttpStatus.OK
        );
    }

}
