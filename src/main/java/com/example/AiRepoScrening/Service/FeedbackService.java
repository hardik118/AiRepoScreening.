package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Model.Feedback;
import com.example.AiRepoScrening.Repository.FeedbackRepo;
import com.example.AiRepoScrening.Service.Impl.FeedbackServiceImpl;
import com.example.AiRepoScrening.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackService implements FeedbackServiceImpl {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public FeedbackResDto viewFeedbackBySubmissionId(Long submissionId){
        Feedback feedback= feedbackRepo.findBySubmissionsId(submissionId)
                .orElseThrow(()-> new RuntimeException("no feedback for the submission right now check later "));

        return feedbackMapper.toDto(feedback);

    }
    @Override
    public  void generateFeedbackBySubmissionId(Long submissionId){

    }


}
