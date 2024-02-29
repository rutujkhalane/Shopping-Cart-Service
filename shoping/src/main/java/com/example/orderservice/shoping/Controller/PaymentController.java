package com.example.orderservice.shoping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.shoping.DTO.PaymentDTO;
import com.example.orderservice.shoping.Entity.Payment;
import com.example.orderservice.shoping.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/checkout")
    public ResponseEntity<Payment> initiateCheckout(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentService.initiatePayment(paymentDTO);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Payment> getPaymentDetails(@PathVariable("orderId") Long orderId) {
        Payment payment = paymentService.getPaymentByOrderId(orderId);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Payment>> getPaymentHistory() {
        List<Payment> paymentHistory = paymentService.getPaymentHistory();
        return ResponseEntity.ok(paymentHistory);
    }
}

