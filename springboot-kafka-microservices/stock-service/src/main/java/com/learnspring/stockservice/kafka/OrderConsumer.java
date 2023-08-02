package com.learnspring.stockservice.kafka;

import com.learnspring.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {
        this.logger.info(String.format("Order event received in stock service -> %s", event));

        // Here we can save event data in database.
        // Also, we can check the users order details for availability and act upon it.
    }
}
