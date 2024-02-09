package com.devstack.orderserviceapi.repo;

import com.devstack.orderserviceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Long> {

@Query(value = "SELECT * FROM order_table WHERE customer_id=?1",nativeQuery = true)
List<Order> getOrdersByCustomer(Long id);

}
