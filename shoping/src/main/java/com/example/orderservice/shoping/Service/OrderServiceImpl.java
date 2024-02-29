package com.example.orderservice.shoping.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.orderservice.shoping.DTO.OrderDTO;
import com.example.orderservice.shoping.Entity.Order;
import com.example.orderservice.shoping.Entity.OrderItem;
import com.example.orderservice.shoping.Entity.Product;
import com.example.orderservice.shoping.Repository.OrderItemRepository;
import com.example.orderservice.shoping.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            
            return null;
        }

        Order order = convertToOrder(orderDTO);
        order = orderRepository.save(order);

        final Order finalOrder = order;

        List<OrderItem> orderItems = orderDTO.getOrderItems().stream()
                .map(itemDTO -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(finalOrder);

                    if (itemDTO.getProduct() != null) {
                        Product product = productService.convertToProduct(itemDTO.getProduct());
                        if (product != null && product.getProductId() != null) {
                            orderItem.setProduct(product);
                        } else {
                            
                        }
                    } else {
                        
                    }

                    orderItem.setQuantity(itemDTO.getQuantity());
                    orderItem.setUnitPrice(itemDTO.getUnitPrice());
                    return orderItem;
                })
                .collect(Collectors.toList());

        orderItemRepository.saveAll(orderItems);

        OrderDTO resultOrderDTO = new OrderDTO();
        resultOrderDTO.setOrderId(order.getOrderId());
        resultOrderDTO.setCustomerMobileNumber(order.getCustomerMobileNumber());
        

        return resultOrderDTO;
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            OrderDTO orderDTO = convertToOrderDTO(order);
            return orderDTO;
        }
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerMobileNumber(String customerMobileNumber) {
        List<Order> orders = orderRepository.findByCustomerMobileNumber(customerMobileNumber);
        return orders.stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomerMobileNumber(order.getCustomerMobileNumber());
        
        return orderDTO;
    }

    public Order convertToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerMobileNumber(orderDTO.getCustomerMobileNumber());
        
        return order;
    }

    @Override
    public Order convertToOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

  
}
