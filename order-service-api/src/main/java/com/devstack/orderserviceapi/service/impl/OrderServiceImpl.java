package com.devstack.orderserviceapi.service.impl;

import com.devstack.orderserviceapi.dto.OrderDto;
import com.devstack.orderserviceapi.dto.ResponseOrderDto;
import com.devstack.orderserviceapi.entity.Order;
import com.devstack.orderserviceapi.repo.OrderRepo;
import com.devstack.orderserviceapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public void makeOrder(OrderDto dto) {
        Order order= new Order(dto.getOrderId(), dto.getCustomerId(), dto.getProductId(), dto.getCost());
        orderRepo.save(order);
    }

    @Override
    public ResponseOrderDto loadOrdersByCustomer(Long id) {

        List<Order> orders = orderRepo.getOrdersByCustomer(id);
        List<OrderDto> dtos = new ArrayList<>();
        for (Order o:orders
        ) {
            dtos.add(new OrderDto(o.getOrderId(),o.getCustomerId(),o.getProductId(),o.getCost()));
        }
        return new ResponseOrderDto(dtos);
    }
}
