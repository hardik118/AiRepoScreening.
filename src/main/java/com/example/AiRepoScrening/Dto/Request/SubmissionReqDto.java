package com.example.AiRepoScrening.Dto.Request;


import lombok.Data;

@Data
public class SubmissionReqDto {
    private String repoUrl;
    private Long studentId;
    private Long assignmentId;

}
