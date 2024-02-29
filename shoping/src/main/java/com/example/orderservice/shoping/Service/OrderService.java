package com.example.orderservice.shoping.Service;

import java.util.List;

import com.example.orderservice.shoping.DTO.OrderDTO;
import com.example.orderservice.shoping.Entity.Order;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long orderId);
    
    

    List<OrderDTO> getOrdersByCustomerMobileNumber(String customerMobileNumber);

	Order convertToOrder(OrderDTO orderDTO);

	Order convertToOrder(Long orderId);
}