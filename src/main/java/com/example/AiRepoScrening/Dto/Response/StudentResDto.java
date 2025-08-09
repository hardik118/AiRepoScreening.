package com.example.AiRepoScrening.Dto.Response;

import lombok.Data;

@Data
public class StudentResDto {
    private  Long Id;
    private String name;
    private String email;
    private Long classroomId;
}
