package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;
import com.example.AiRepoScrening.Model.*;
import com.example.AiRepoScrening.Repository.AssignmentRepo;
import com.example.AiRepoScrening.Repository.FeedbackRepo;
import com.example.AiRepoScrening.Repository.StudentRepo;
import com.example.AiRepoScrening.Repository.SubmissionRepo;
import com.example.AiRepoScrening.Service.Impl.StudentServiceImpl;
import com.example.AiRepoScrening.mapper.FeedbackMapper;
import com.example.AiRepoScrening.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class StudentService implements StudentServiceImpl {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private FeedbackMapper feedbackMapper;






    @Override
    public StudentResDto signup(StudentReqDto studentReqDto){

        Student  student  = studentMapper.fromRequestDto(studentReqDto);
        Optional<Student> studentToExists = studentRepo.findByEmail(student.getEmail());
        if(studentToExists.isPresent()) throw new UsernameNotFoundException("user Email is already registered");

        Student savedStudent= studentRepo.save(student);
        return  studentMapper.toDto(savedStudent);

    }

    @Override
    public  StudentResDto login(String email, String password){
        Student studentToExists = studentRepo.findByEmail(email).
                orElseThrow(()->new RuntimeException("user email is not registered "));

        if(!studentToExists.getPassword().equals(password)){
            throw  new RuntimeException(("password is not valid for the registered user"));

        }

        return  studentMapper.toDto(studentToExists);
    }

    @Override
    public  void joinClassroom(Long classroomId, Long uniqueClassroomId){}


    @Override
    public  void  submitAssignment(Long studentId, Long assignmentId,  String repoUrl){
        LocalDateTime currentTime = LocalDateTime.now();

        Assignments assignmentsToExists= assignmentRepo.findById(assignmentId)
                .orElseThrow(()->new RuntimeException("No assignment for such id req exists"));

        Student studentToExists = studentRepo.findById(studentId)
                .orElseThrow(()->new RuntimeException("not student with such id req exists"));


        if((assignmentsToExists.getDeadLine() != null && currentTime.isAfter(assignmentsToExists.getDeadLine()))){
            throw  new RuntimeException("assignment could not be accepted, you missed the deadline ");

        }

        Submissions savedSubmission= new Submissions();
        savedSubmission.setAssignments(assignmentsToExists);
        savedSubmission.setStudent(studentToExists);
        savedSubmission.setRepoUrl(repoUrl);
        savedSubmission.setSubmittedAt(currentTime);

        submissionRepo.save(savedSubmission);

        return;

    }

    @Override
    public FeedbackResDto viewFeedback(Long assignmentId, Long  StudentId, Long submissionId ){

        Assignments assignmentsToExists= assignmentRepo.findById(assignmentId)
                .orElseThrow(()->new RuntimeException("No assignment for such id req exists"));

        Student studentToExists = studentRepo.findById(StudentId)
                .orElseThrow(()->new RuntimeException("not student with such id req exists"));

        Feedback userAssignmentFeedback=  feedbackRepo.findBySubmissionsId(submissionId)
                .orElseThrow(()->new RuntimeException("Feedback does not seem to exists"));

        return  feedbackMapper.toDto(userAssignmentFeedback);

    }

    @Override
    public  StudentResDto viewProfile(StudentReqDto studentReqDto){
        Student  student  = studentMapper.fromRequestDto(studentReqDto);
        Optional<Student> studentToExists = studentRepo.findByEmail(student.getEmail());
        if(studentToExists.isEmpty()) throw new UsernameNotFoundException("user Email does not exists");
        return  studentMapper.toDto(studentToExists.get());



    }












}
