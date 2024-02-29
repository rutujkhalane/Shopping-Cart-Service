package com.example.orderservice.shoping.Service;

import com.example.orderservice.shoping.DTO.ProductDTO;
import com.example.orderservice.shoping.Entity.Product;

public class ProductConversionService {

    public static Product convertToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        
        return product;
    }
}
