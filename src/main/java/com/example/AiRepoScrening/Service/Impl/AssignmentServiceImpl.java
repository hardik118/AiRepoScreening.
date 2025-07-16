package com.example.AiRepoScrening.Service.Impl;

import com.example.AiRepoScrening.Dto.Request.AssignmentReqDto;
import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;

import java.util.List;

public interface AssignmentServiceImpl {

    AssignmentResDto getAssignmentByAssignmentId(Long assignmentId);
    List<AssignmentResDto> getAssignmentByTeacherId(Long teacherId);
    List<AssignmentResDto> getAssignmentByClassroomId(Long classroomId);
    boolean getAssignmentStatus( Long assignmentId);



}
