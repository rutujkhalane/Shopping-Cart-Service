package com.example.orderservice.shoping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.shoping.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
	
	 List<CartItem> findAllByShoppingCart_CustomerMobileNumber(String customerMobileNumber);
}
