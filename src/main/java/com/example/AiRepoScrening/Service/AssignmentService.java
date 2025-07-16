package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Model.Assignments;
import com.example.AiRepoScrening.Model.Classroom;
import com.example.AiRepoScrening.Model.Teacher;
import com.example.AiRepoScrening.Repository.AssignmentRepo;
import com.example.AiRepoScrening.Repository.ClassroomRepo;
import com.example.AiRepoScrening.Repository.TeacherRepo;
import com.example.AiRepoScrening.Service.Impl.AssignmentServiceImpl;
import com.example.AiRepoScrening.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentService implements AssignmentServiceImpl {

    @Autowired
    private AssignmentRepo assignmentRepo;
    @Autowired
    private AssignmentMapper assignmentMapper;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private ClassroomRepo classroomRepo;





    @Override
    public AssignmentResDto getAssignmentByAssignmentId(Long assignmentId){

        Assignments assignments=   assignmentRepo.findById(assignmentId)
                .orElseThrow(()->new RuntimeException("the assignment for the req Id could not be found "));
        return assignmentMapper.toDto(assignments);

    }

    @Override
    public List<AssignmentResDto> getAssignmentByTeacherId(Long teacherId){
        Teacher  teacher =  teacherRepo.findById(teacherId)
                .orElseThrow(()->new RuntimeException("NO teacher with such id found "));

       List<Assignments>  assignmentsList = assignmentRepo.findByTeacherId(teacherId);
       if(assignmentsList.isEmpty()) throw  new RuntimeException("not assignment could be found ");

       return  assignmentsList.stream()
               .map(assignmentMapper::toDto)
               .collect(Collectors.toList());

    }

    @Override
    public  List<AssignmentResDto> getAssignmentByClassroomId(Long classroomId){

       Classroom classroom =  classroomRepo.findById(classroomId)
                .orElseThrow(()->new RuntimeException("NO classroom with such id found "));

        List<Assignments>  assignmentsList = assignmentRepo.findByClassroomId(classroomId);
        if(assignmentsList.isEmpty()) throw  new RuntimeException("not assignment could be found ");

        return  assignmentsList.stream()
                .map(assignmentMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public boolean getAssignmentStatus( Long assignmentId){
        LocalDateTime now= LocalDateTime.now();

        Assignments assignments= assignmentRepo.findById(assignmentId)
                .orElseThrow(()->new RuntimeException("the assignment is  invalid "));

        return now.isAfter(assignments.getDeadLine());

    }





}
