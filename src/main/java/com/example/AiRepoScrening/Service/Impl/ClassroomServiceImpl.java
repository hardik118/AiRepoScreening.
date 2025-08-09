package com.example.AiRepoScrening.Service.Impl;

import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;

import java.util.List;

public interface ClassroomServiceImpl {

    ClassroomResDto findClassroomByTeacherId(Long teacherId);

    List<AssignmentResDto> findAssignmentsByClassroomId(Long classroomId);





}
