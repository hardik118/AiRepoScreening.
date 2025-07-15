package com.example.AiRepoScrening.Impl;

import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;

public interface StudentServiceImpl {
    StudentResDto signup(StudentReqDto studentReqDto);
    StudentResDto login(String email, String password);
    void joinClassroom(Long classroomId, Long uniqueClassroomId);
    AssignmentResDto submitAssignment(String repoUrl);
    FeedbackResDto viewFeedback(Long assignmentId,Long  StudentId );
    StudentResDto viewProfile(StudentReqDto studentReqDto);



}
