package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Response.SubmissionResDto;
import com.example.AiRepoScrening.Model.Submissions;
import com.example.AiRepoScrening.Repository.SubmissionRepo;
import com.example.AiRepoScrening.Service.Impl.SubmissionServiceImpl;
import com.example.AiRepoScrening.mapper.SubmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubmissionService implements SubmissionServiceImpl {

    @Autowired
    private SubmissionRepo submissionRepo;
    @Autowired
    private SubmissionMapper submissionMapper;



    @Override
    public List<SubmissionResDto> viewSubmissionByAssignmentId(Long assignmentId){
        List<Submissions> submissionsList= submissionRepo.findByAssignmentId(assignmentId);
        if(submissionsList.isEmpty()) throw  new RuntimeException("no Submission for the following assignment");

        return submissionsList.stream()
                .map(submissionMapper::toDto )
                .collect(Collectors.toList());

    }
    @Override
    public   List<SubmissionResDto> viewSubmissionByStudentId(Long studentId){
        List<Submissions> submissionsList= submissionRepo.findByStudentId(studentId);
        if(submissionsList.isEmpty()) throw  new RuntimeException("no Submission for the following student");

        return submissionsList.stream()
                .map(submissionMapper::toDto )
                .collect(Collectors.toList());

    }

    @Override
    public   SubmissionResDto getSubmissionById(Long submissionId){
        Submissions submission= submissionRepo.findById(submissionId)
                .orElseThrow(()-> new RuntimeException("no submission for the req"));
        return  submissionMapper.toDto(submission);




    }



}
