package com.example.AiRepoScrening.Kafka;



import com.example.AiRepoScrening.Model.FeedbackProducerRequest;
import com.example.AiRepoScrening.Model.FeedbackProducerResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Simple producer for sending evaluation requests to Kafka
 * Last Updated: 2025-08-08 15:53:47 by hardik118
 */
@Slf4j
@Service
public class FeedbackProducer {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String evaluationTopic;

    @Autowired
    public FeedbackProducer(
            KafkaTemplate<String, String> kafkaTemplate,
            @Value("${app.kafka.topics.evaluation-requests:evaluationTopic}") String evaluationTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
        this.evaluationTopic = evaluationTopic;
    }

    /**
     * Send evaluation request to Kafka topic
     *
     * @param request The evaluation request to send
     */
    public void sendEvaluationRequest(FeedbackProducerRequest request) {
        try {
            log.info("Sending evaluation request for repo: {} with ID: {}",
                    request.getRepoUrl(), request.getSubmissionId());

            String requestJson = objectMapper.writeValueAsString(request);
            String key = request.getSubmissionId().toString();

            kafkaTemplate.send(evaluationTopic, key, requestJson);
            logger.info("Evaluation result: {}", requestJson);

            log.info("Successfully sent evaluation request to topic: {}", evaluationTopic);

        } catch (Exception e) {
            log.error("Failed to send evaluation request. Error: {}", e.getMessage());
        }
    }
}