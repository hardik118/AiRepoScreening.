package com.example.AiRepoScrening.Dto.Request;


import lombok.Data;

@Data
public class StudentReqDto {

    private String name;
    private String email;
    private String  password;
    private Long classroomId;

}
