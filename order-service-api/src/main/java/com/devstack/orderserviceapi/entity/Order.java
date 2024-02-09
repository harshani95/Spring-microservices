package com.devstack.orderserviceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "cost")
    private Double cost;
}
