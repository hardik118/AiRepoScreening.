package com.example.AiRepoScrening.Service.Impl;

import com.example.AiRepoScrening.Dto.Request.AssignmentReqDto;
import com.example.AiRepoScrening.Dto.Request.ClassroomReqDto;
import com.example.AiRepoScrening.Dto.Request.TeacherReqDto;
import com.example.AiRepoScrening.Dto.Response.*;
import com.example.AiRepoScrening.Model.Assignments;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherServiceImpl {

    TeacherResDto signup(TeacherReqDto teacherReqDto);
    TeacherResDto login(String email, String password);
    TeacherResDto viewProfile(Long teacherId);
   void createClassroom(Long teacherId, ClassroomReqDto classroomReqDto);
   ClassroomResDto viewClassroom(Long  uniqueClassroomId);
   void createAssignment(Long teacherId, AssignmentReqDto assignmentReqDto);
   List<SubmissionResDto> viewSubmissions(Long teacherId, Long assignmentId);
   List<StudentResDto> viewStudents(Long teacherId, Long classroomId);
    List<AssignmentResDto> viewClassroomAssignments(Long classroomId);






}
