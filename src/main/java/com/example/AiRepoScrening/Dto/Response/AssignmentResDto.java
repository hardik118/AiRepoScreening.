package com.example.AiRepoScrening.Dto.Response;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AssignmentResDto {
    private  Long Id;

    private  String title;

    private String description;

    private LocalDateTime deadLine;

    private String  classroomName;

    private String  createdByName;

}
