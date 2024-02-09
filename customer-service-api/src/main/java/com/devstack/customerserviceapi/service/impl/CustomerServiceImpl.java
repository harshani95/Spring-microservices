package com.devstack.customerserviceapi.service.impl;

import com.devstack.customerserviceapi.dto.CustomerDto;
import com.devstack.customerserviceapi.dto.ResponseCustomerDto;
import com.devstack.customerserviceapi.dto.ResponseOrderDto;
import com.devstack.customerserviceapi.entity.Customer;
import com.devstack.customerserviceapi.feigns.OrderFeignClient;
import com.devstack.customerserviceapi.repo.CustomerRepo;
import com.devstack.customerserviceapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    private WebClient webClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    @Override
    public void createCustomer(CustomerDto dto) {
        Customer customer = new Customer(
                dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()
        );

        customerRepo.save(customer);
    }

    @Override
    public ResponseCustomerDto findCustomerById(Long id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()){
            throw new RuntimeException("Not found!");
        }
        //ResponseOrderDto orders = findOrders(selectedCustomer.get().getId());
        ResponseOrderDto orders = orderFeignClient.findOrdersByCustomer(id);

        CustomerDto customerDto = new CustomerDto(selectedCustomer.get().getId(),
                selectedCustomer.get().getName(), selectedCustomer.get().getAddress(),
                selectedCustomer.get().getSalary());
        return new ResponseCustomerDto(customerDto,orders);
    }

    private ResponseOrderDto findOrders(Long id){
        Mono<ResponseOrderDto> orderDtoMono = webClient.get().uri("/get-by-customer-id/" + id)
                .retrieve().bodyToMono(ResponseOrderDto.class);
        return orderDtoMono.block();
    }
}
