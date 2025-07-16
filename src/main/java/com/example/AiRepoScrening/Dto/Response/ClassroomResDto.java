package com.example.AiRepoScrening.Dto.Response;

import lombok.Data;

import java.util.List;

@Data
public class ClassroomResDto {
    private Long Id;
    private String name;
    private Long teacherId;
    private Long classroomId;
    private List<Long> studentIds;
    private  List<Long> assignmentsIds;


}
