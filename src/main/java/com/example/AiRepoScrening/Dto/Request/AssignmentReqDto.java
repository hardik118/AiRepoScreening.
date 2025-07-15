package com.example.AiRepoScrening.Dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignmentReqDto {
    @NotNull
    private  String title;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime deadLine;

    @NotNull
    private Long classroomId;

    @NotNull
    private Long createdById;

}
