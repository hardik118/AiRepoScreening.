package com.example.AiRepoScrening.Impl;

import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;

import java.util.List;

public interface ClassroomServiceImpl {

    ClassroomResDto createClassroom(ClassroomResDto classroomResDto);
    ClassroomResDto findClassroomByTeacherId(Long teacherId);
    List<StudentResDto> findStudentsByClassroomId(Long classroomId);
    List<AssignmentResDto> findAssignmentsByClassroomId(Long classroomId);





}
