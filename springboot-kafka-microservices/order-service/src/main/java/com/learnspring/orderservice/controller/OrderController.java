package com.learnspring.orderservice.controller;

import com.learnspring.basedomains.dto.Order;
import com.learnspring.basedomains.dto.OrderEvent;
import com.learnspring.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {

        order.setOrderId("KRISHNA_RESTAURANT-" + Instant.now().toString() + "-" + UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state.");
        orderEvent.setOrder(order);

        this.orderProducer.sendMessage(orderEvent);

        return ResponseEntity.ok("Order placed successfully !!");
    }
}
