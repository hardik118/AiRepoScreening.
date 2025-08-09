package com.example.AiRepoScrening.Dto.Request;

import lombok.Data;

@Data
public class FeedbackReqDto {
    private Integer score;
    private String comment;
    private Long submissionId;



}
