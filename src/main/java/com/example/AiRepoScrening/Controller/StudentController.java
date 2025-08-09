package com.example.AiRepoScrening.Controller;

import com.example.AiRepoScrening.Dto.Request.LoginReqDto;
import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;
import com.example.AiRepoScrening.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/main/student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Signup
    @PostMapping("/signup/{classroomId}")
    public StudentResDto signup(@PathVariable Long classroomId, @RequestBody StudentReqDto studentReqDto) {
        return studentService.signup(classroomId, studentReqDto);
    }

    // 2. Login
    @PostMapping("/login")
    public StudentResDto login(@RequestBody LoginReqDto loginDto) {
        return studentService.login(loginDto.getEmail(), loginDto.getPassword());
    }



    // 4. Submit Assignment
    @PostMapping("/submit")
    public void submitAssignment(@RequestParam Long studentId, @RequestParam Long assignmentId, @RequestParam String repoUrl) {
        studentService.submitAssignment(studentId, assignmentId, repoUrl);
    }

    // 5. View Feedback
    @GetMapping("/feedback")
    public FeedbackResDto viewFeedback(@RequestParam Long assignmentId, @RequestParam Long studentId, @RequestParam Long submissionId) {
        return studentService.viewFeedback(assignmentId, studentId, submissionId);
    }

    // 6. View Profile
    @GetMapping("/profile")
    public StudentResDto viewProfile(@RequestParam Long studentId) {
        return studentService.viewProfile(studentId);
    }
}


