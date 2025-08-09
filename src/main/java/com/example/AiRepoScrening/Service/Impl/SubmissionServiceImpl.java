package com.example.AiRepoScrening.Service.Impl;


import com.example.AiRepoScrening.Dto.Response.SubmissionResDto;
import org.mapstruct.Mapper;

import java.util.List;

public interface SubmissionServiceImpl {

  List<SubmissionResDto> viewSubmissionByAssignmentId(Long assignmentId);
  List<SubmissionResDto> viewSubmissionByStudentId(Long studentId);
  SubmissionResDto getSubmissionById(Long submissionId);



}
