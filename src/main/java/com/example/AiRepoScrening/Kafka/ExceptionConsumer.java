package com.example.AiRepoScrening.Kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExceptionConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionConsumer.class);

    @KafkaListener(topics = "evaluationFailureTopic", groupId = "main-service-exception-consumer")
    public void consumeException(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();

        logger.warn("📛 Received evaluation failure for submission ID {}: {}", key, value);
    }
}