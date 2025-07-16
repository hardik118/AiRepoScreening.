package com.example.AiRepoScrening.Service.Impl;

import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;

public interface StudentServiceImpl {
    StudentResDto signup(StudentReqDto studentReqDto);
    StudentResDto login(String email, String password);
    void joinClassroom(Long classroomId, Long uniqueClassroomId);
    void  submitAssignment(Long studentId, Long assignmentId,  String repoUrl);
    FeedbackResDto viewFeedback(Long assignmentId,Long  StudentId, Long submissionId  );
    StudentResDto viewProfile(StudentReqDto studentReqDto);



}
