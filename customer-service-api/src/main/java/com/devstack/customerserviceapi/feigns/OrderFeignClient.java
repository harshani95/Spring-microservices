package com.devstack.customerserviceapi.feigns;

import com.devstack.customerserviceapi.dto.ResponseOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${order.service.url}", path = "/api/v1/orders", value = "order-feign-client")
public interface OrderFeignClient {
    @GetMapping("/get-by-customer-id/{id}")
    public ResponseOrderDto findOrdersByCustomer(@PathVariable Long id);
}
