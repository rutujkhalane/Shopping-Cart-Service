package com.example.orderservice.shoping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.shoping.DTO.OrderDTO;
import com.example.orderservice.shoping.DTO.PaymentDTO;
import com.example.orderservice.shoping.Entity.Order;
import com.example.orderservice.shoping.Entity.Payment;
import com.example.orderservice.shoping.Entity.PaymentStatus;
import com.example.orderservice.shoping.Repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public Payment initiatePayment(PaymentDTO paymentDTO) {
        
        
        Order order = orderService.convertToOrder(orderService.getOrderById(paymentDTO.getOrderId()));

        
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentStatus(PaymentStatus.PENDING);

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByOrderId(Long orderId) {
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        Order order = orderService.convertToOrder(orderDTO);

        List<Payment> payments = paymentRepository.findByOrder(order);

        
        return payments.isEmpty() ? null : payments.get(0);
    }

    @Override
    public List<Payment> getPaymentHistory() {
        
        return paymentRepository.findAll();
    }
}
