package com.example.AiRepoScrening.Controller;

import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/main/student/feedback")
public class FeedbackController {

    @Autowired
    private final  FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService= feedbackService;

    }

    // 1. Generate feedback for a submission
    @PostMapping("/generate/{submissionId}")
    public ResponseEntity<String> generateFeedback(@PathVariable Long submissionId) {
        feedbackService.generateFeedbackBySubmissionId(submissionId);
        return ResponseEntity.ok("Feedback generated successfully for submission ID: " + submissionId);
    }

    // 2. View feedback for a submission
    @GetMapping("/{submissionId}")
    public ResponseEntity<FeedbackResDto> viewFeedback(@PathVariable Long submissionId) {
        FeedbackResDto feedback = feedbackService.viewFeedbackBySubmissionId(submissionId);
        return ResponseEntity.ok(feedback);
    }

}
