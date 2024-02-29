package com.example.orderservice.shoping.Service;

import java.util.List;
import java.util.Optional;

import com.example.orderservice.shoping.DTO.ProductDTO;
import com.example.orderservice.shoping.Entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long productId);
    Product addProduct(Product product);
    Product updateProduct(Long productId, Product updatedProduct);
    void deleteProduct(Long productId);
    List<Product> getProductsByCategory(String category);
	Product convertToProduct(ProductDTO product);
}