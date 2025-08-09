package com.example.AiRepoScrening.Controller;

import com.example.AiRepoScrening.Dto.Response.SubmissionResDto;
import com.example.AiRepoScrening.Service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/main/submissions")
public class SubmissionController {
    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    // 1. Get all submissions for a given assignment
    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<SubmissionResDto>> getSubmissionsByAssignmentId(@PathVariable Long assignmentId) {
        List<SubmissionResDto> submissions = submissionService.viewSubmissionByAssignmentId(assignmentId);
        return ResponseEntity.ok(submissions);
    }

    // 2. Get all submissions by a student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<SubmissionResDto>> getSubmissionsByStudentId(@PathVariable Long studentId) {
        List<SubmissionResDto> submissions = submissionService.viewSubmissionByStudentId(studentId);
        return ResponseEntity.ok(submissions);
    }

    // 3. Get a specific submission by its ID
    @GetMapping("/{submissionId}")
    public ResponseEntity<SubmissionResDto> getSubmissionById(@PathVariable Long submissionId) {
        SubmissionResDto submission = submissionService.getSubmissionById(submissionId);
        return ResponseEntity.ok(submission);
    }
}
