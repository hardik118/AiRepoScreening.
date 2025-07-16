package com.example.AiRepoScrening.Dto.Response;


import lombok.Data;

@Data
public class FeedbackResDto {
    private Long Id;
    private Integer score;
    private String comment;
    private Long submissionId;
}
