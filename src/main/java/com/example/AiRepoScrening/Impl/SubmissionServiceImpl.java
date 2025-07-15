package com.example.AiRepoScrening.Impl;


import com.example.AiRepoScrening.Dto.Response.SubmissionResDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface SubmissionServiceImpl {

  SubmissionResDto viewSubmissionByAssignmentId(Long assignmentId);
  SubmissionResDto viewSubmissionByStudentId(Long studentId);
  SubmissionResDto getSubmissionById(Long submissionId);



}
