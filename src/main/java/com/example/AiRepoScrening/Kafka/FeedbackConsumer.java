package com.example.AiRepoScrening.Kafka;

import com.example.AiRepoScrening.Model.FeedbackProducerResult;
import com.example.AiRepoScrening.Service.SubmissionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Consumes evaluation feedback messages from Kafka
 */
@Slf4j
@Component
public class FeedbackConsumer {
    private final ObjectMapper objectMapper;
    private final SubmissionService submissionService;
    private static final Logger logger = LoggerFactory.getLogger(FeedbackConsumer.class);

    @Autowired
    public FeedbackConsumer(ObjectMapper objectMapper, SubmissionService submissionService) {
        this.objectMapper = objectMapper;
        this.submissionService = submissionService;
    }

    /**
     * Consume feedback messages with evaluation results
     *
     * @param feedback The JSON message from Kafka
     *                EvaluationFeedback
     */
    @KafkaListener(topics = "EvaluationFeedback")
    public void consumeFeedback(FeedbackProducerResult feedback) {
        try {
            log.info("Received evaluation feedback message");

            // Update submission with evaluation result
            logger.info("Evaluation result: {}", feedback);


        } catch (Exception e) {
            log.error("Error processing evaluation feedback message: {}", e.getMessage(), e);
        }
    }
}
