package com.example.AiRepoScrening.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackProducerRequest {
    private String repoUrl;
    private Long submissionId;
    private String title;
    private String description;

}
