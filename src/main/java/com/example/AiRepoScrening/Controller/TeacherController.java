package com.example.AiRepoScrening.Controller;

import com.example.AiRepoScrening.Dto.Request.AssignmentReqDto;
import com.example.AiRepoScrening.Dto.Request.ClassroomReqDto;
import com.example.AiRepoScrening.Dto.Request.LoginReqDto;
import com.example.AiRepoScrening.Dto.Request.TeacherReqDto;
import com.example.AiRepoScrening.Dto.Response.*;
import com.example.AiRepoScrening.Service.TeacherService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/main/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }



    //1- signup
    @PostMapping("/Signup")
    public TeacherResDto Signup(@RequestBody TeacherReqDto teacherReqDto){
        return teacherService.signup(teacherReqDto);

    }

    //2-login

    @PostMapping("/login")
    public TeacherResDto login(@RequestBody LoginReqDto loginReqDto){
        return teacherService.login(loginReqDto.getEmail(), loginReqDto.getPassword());

    }

    // 3. View Profile
    @GetMapping("/{teacherId}/profile")
    public TeacherResDto viewProfile(@PathVariable Long teacherId) {
        return teacherService.viewProfile(teacherId);
    }

    // 4. Create Classroom
    @PostMapping("/{teacherId}/classrooms")
    public void createClassroom(@PathVariable Long teacherId, @RequestBody ClassroomReqDto classroomReqDto) {
        teacherService.createClassroom(teacherId, classroomReqDto);
    }

    // 5. View Classroom
    @GetMapping("/classrooms/{classroomUniqueId}")
    public ClassroomResDto viewClassroom(@PathVariable Long classroomUniqueId) {
        return teacherService.viewClassroom(classroomUniqueId);
    }




    // 6. Create Assignment
    @PostMapping("/{teacherId}/assignments")
    public void createAssignment(@PathVariable Long teacherId, @RequestBody AssignmentReqDto assignmentReqDto) {
        teacherService.createAssignment(teacherId, assignmentReqDto);
    }

    // 7. View Submissions for Assignment
    @GetMapping("/{teacherId}/assignments/{assignmentId}/submissions")
    public List<SubmissionResDto> viewSubmissions(@PathVariable Long teacherId, @PathVariable Long assignmentId) {
        return teacherService.viewSubmissions(teacherId, assignmentId);
    }

    // 8. View Students in Classroom
    @GetMapping("/{teacherId}/classrooms/{classroomId}/students")
    public List<StudentResDto> viewStudents(@PathVariable Long teacherId, @PathVariable Long classroomId) {
        return teacherService.viewStudents(teacherId, classroomId);
    }

    // 9. View Assignments  in Classroom
    @GetMapping("/classrooms/{classroomId}/assignments")
    public List<AssignmentResDto> viewAssignments(@PathVariable Long classroomId) {
        return teacherService.viewClassroomAssignments(classroomId);
    }
 }
