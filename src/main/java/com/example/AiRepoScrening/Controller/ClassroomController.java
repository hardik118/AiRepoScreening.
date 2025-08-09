package com.example.AiRepoScrening.Controller;

import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/main/classroom")
public class ClassroomController {
    @Autowired
    private  final  ClassroomService classroomService;

    public  ClassroomController(ClassroomService classroomService){
        this.classroomService=classroomService;

    }


    // 1. Find classroom by teacher ID
    @GetMapping("/teacher/{teacherId}")
    public ClassroomResDto findClassroomByTeacherId(@PathVariable Long teacherId) {
        return classroomService.findClassroomByTeacherId(teacherId);
    }

    // 2. Get all assignments by classroom ID
    @GetMapping("/{classroomId}/assignments")
    public List<AssignmentResDto> findAssignmentsByClassroomId(@PathVariable Long classroomId) {
        return classroomService.findAssignmentsByClassroomId(classroomId);
    }
}
