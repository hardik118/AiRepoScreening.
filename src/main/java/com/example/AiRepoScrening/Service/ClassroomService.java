package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Model.Assignments;
import com.example.AiRepoScrening.Model.Classroom;
import com.example.AiRepoScrening.Model.Teacher;
import com.example.AiRepoScrening.Repository.AssignmentRepo;
import com.example.AiRepoScrening.Repository.ClassroomRepo;
import com.example.AiRepoScrening.Repository.TeacherRepo;
import com.example.AiRepoScrening.Service.Impl.ClassroomServiceImpl;
import com.example.AiRepoScrening.mapper.AssignmentMapper;
import com.example.AiRepoScrening.mapper.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ClassroomService implements ClassroomServiceImpl {

    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private ClassroomRepo classroomRepo;
    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private AssignmentMapper assignmentMapper;



    @Override
    public  ClassroomResDto findClassroomByTeacherId(Long teacherId){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Classroom classroom = classroomRepo.findByTeacherId(teacherId)
                .orElseThrow(()-> new RuntimeException("classroom  could  not  be found  "));

        return  classroomMapper.toDto(classroom);
    }

    @Override
    public List<AssignmentResDto> findAssignmentsByClassroomId(Long classroomId){
        Classroom classroom= classroomRepo.findById(classroomId)
                .orElseThrow(()->new RuntimeException(" no such classroom exists"));

        List<Assignments> assignmentstList= assignmentRepo.findAllByClassroomId(classroomId);
        if(assignmentstList.isEmpty()) throw  new RuntimeException("no assignment is created by teacher for now");

        return  assignmentstList.stream()
                .map(assignmentMapper::toDto)
                .collect(Collectors.toList());
    }






}
