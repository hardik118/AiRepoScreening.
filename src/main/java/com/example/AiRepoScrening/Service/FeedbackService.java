package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Model.Feedback;
import com.example.AiRepoScrening.Model.Submissions;
import com.example.AiRepoScrening.Repository.FeedbackRepo;
import com.example.AiRepoScrening.Repository.SubmissionRepo;
import com.example.AiRepoScrening.Service.Impl.FeedbackServiceImpl;
import com.example.AiRepoScrening.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements FeedbackServiceImpl {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private SubmissionRepo submissionRepo;


    @Override
    public FeedbackResDto viewFeedbackBySubmissionId(Long submissionId){
        Feedback feedback= feedbackRepo.findBySubmissionsId(submissionId)
                .orElseThrow(()-> new RuntimeException("no feedback for the submission right now check later "));

        return feedbackMapper.toDto(feedback);

    }
    @Override
    public  void generateFeedbackBySubmissionId(Long submissionId){
        Submissions submission = submissionRepo.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found with id: " + submissionId));

        // Create hardcoded feedback
        Feedback feedback = new Feedback();
        feedback.setScore(85); // hardcoded score
        feedback.setComment("Well done! Your implementation is clean, logically structured, and meets the problem requirements.");
        feedback.setSubmissions(submission);

        // Save it in DB
        feedbackRepo.save(feedback);

    }


}
