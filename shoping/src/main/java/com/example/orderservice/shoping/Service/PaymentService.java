package com.example.orderservice.shoping.Service;

import java.util.List;

import com.example.orderservice.shoping.DTO.PaymentDTO;
import com.example.orderservice.shoping.Entity.Payment;

public interface PaymentService {
    Payment initiatePayment(PaymentDTO paymentDTO);
    Payment getPaymentByOrderId(Long orderId);
    List<Payment> getPaymentHistory();
}

