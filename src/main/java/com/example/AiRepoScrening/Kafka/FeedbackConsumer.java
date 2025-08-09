package com.example.AiRepoScrening.Kafka;

import com.example.AiRepoScrening.Model.FeedbackProducerRequest;
import com.example.AiRepoScrening.Service.SubmissionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    public FeedbackConsumer(ObjectMapper objectMapper, SubmissionService submissionService) {
        this.objectMapper = objectMapper;
        this.submissionService = submissionService;
    }

    /**
     * Consume feedback messages with evaluation results
     *
     * @param message The JSON message from Kafka
     */
    @KafkaListener(topics = "EvaluationFeedback", groupId = "main-service-consumer-group")
    public void consumeFeedback(String message) {
        try {
            log.info("Received evaluation feedback message");

            // Convert JSON to evaluation result
            FeedbackProducerRequest evaluationResult = objectMapper.readValue(message, FeedbackProducerRequest.class);

            log.info("Processing evaluation feedback for submission {}", evaluationResult.getSubmissionId());

            // Update submission with evaluation result
            System.out.println(evaluationResult);

            log.info("Successfully processed evaluation feedback for submission {}",
                    evaluationResult.getSubmissionId());

        } catch (Exception e) {
            log.error("Error processing evaluation feedback message: {}", e.getMessage(), e);
        }
    }
}
