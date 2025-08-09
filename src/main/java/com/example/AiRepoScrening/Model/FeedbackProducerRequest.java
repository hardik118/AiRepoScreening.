package com.example.AiRepoScrening.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedbackProducerRequest {


    private String repoUrl;
    private Long submissionId;
    private  String Title;
    private  String Description ;


}
