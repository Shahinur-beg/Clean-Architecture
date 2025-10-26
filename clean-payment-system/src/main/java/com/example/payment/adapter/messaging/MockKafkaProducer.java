package com.example.payment.adapter.messaging;

import org.springframework.stereotype.Component;

@Component
public class MockKafkaProducer {
    public void publish(String topic, String message) {
        System.out.println("[MockKafka] topic='" + topic + "' message='" + message + "'"); // simple log
    }
}
