package com.example.AiRepoScrening.Service.Impl;

import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackServiceImpl {
    void generateFeedbackBySubmissionId(Long submissionId);
    FeedbackResDto viewFeedbackBySubmissionId(Long submissionId);


}
