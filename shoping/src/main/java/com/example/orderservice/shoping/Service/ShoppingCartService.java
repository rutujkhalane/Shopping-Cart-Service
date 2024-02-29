package com.example.orderservice.shoping.Service;

import java.util.List;

import com.example.orderservice.shoping.DTO.CartItemDTO;
import com.example.orderservice.shoping.DTO.ProductDTO;

public interface ShoppingCartService {

    List<CartItemDTO> getShoppingCart(String customerMobileNumber);

    void addToCart(String customerMobileNumber, ProductDTO productDTO);

    void updateCartItem(String customerMobileNumber, CartItemDTO cartItemDTO);

    void removeCartItem(String customerMobileNumber, Long productId);

    void clearCart(String customerMobileNumber);

	
}
