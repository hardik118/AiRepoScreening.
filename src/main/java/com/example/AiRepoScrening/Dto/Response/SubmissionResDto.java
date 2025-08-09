package com.example.AiRepoScrening.Dto.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubmissionResDto {
    private Long id;
    private String repoUrl;
    private LocalDateTime submittedAt;
    private Long studentId;
    private Long assignmentId;
}
