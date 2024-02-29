package com.example.orderservice.shoping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.shoping.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerMobileNumber(String customerMobileNumber);

}