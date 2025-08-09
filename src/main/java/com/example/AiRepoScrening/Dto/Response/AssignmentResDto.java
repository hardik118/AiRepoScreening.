package com.example.AiRepoScrening.Dto.Response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignmentResDto {
    private  Long Id;

    private  String title;

    private String description;

    private LocalDateTime deadLine;

    private String  classroomName;

    private String  createdByName;

}
