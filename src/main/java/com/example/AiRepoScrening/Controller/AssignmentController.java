package com.example.AiRepoScrening.Controller;

import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/main/assignment")
public class AssignmentController {
    @Autowired
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService= assignmentService;

    }

    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssignmentResDto> getAssignmentById(@PathVariable Long assignmentId) {
        AssignmentResDto assignment = assignmentService.getAssignmentByAssignmentId(assignmentId);
        return ResponseEntity.ok(assignment);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<AssignmentResDto>> getAssignmentsByTeacherId(@PathVariable Long teacherId) {
        List<AssignmentResDto> assignments = assignmentService.getAssignmentByTeacherId(teacherId);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/classroom/{classroomId}")
    public ResponseEntity<List<AssignmentResDto>> getAssignmentsByClassroomId(@PathVariable Long classroomId) {
        List<AssignmentResDto> assignments = assignmentService.getAssignmentByClassroomId(classroomId);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{assignmentId}/status")
    public ResponseEntity<Boolean> getAssignmentStatus(@PathVariable Long assignmentId) {
        boolean status = assignmentService.getAssignmentStatus(assignmentId);
        return ResponseEntity.ok(status);
    }

}
