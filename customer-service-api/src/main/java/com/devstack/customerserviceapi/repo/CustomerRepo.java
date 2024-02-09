package com.devstack.customerserviceapi.repo;

import com.devstack.customerserviceapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
