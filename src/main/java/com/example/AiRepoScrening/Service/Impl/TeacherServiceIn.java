package com.example.AiRepoScrening.Service.Impl;

import com.example.AiRepoScrening.Model.Student;
import com.example.AiRepoScrening.Model.Teacher;
import org.hibernate.sql.ast.tree.update.Assignment;

import java.util.List;

public   interface TeacherServiceIn {
    Teacher registerTeacher(com.example.AiRepoScrening.Service.TeacherService teacher);
    Teacher login(String email, String password);
    Teacher getTeacherById(Long teacherId);
    List<Student> getAllStudentsInClassroom(Long classroomId);
    List<Assignment> getAssignmentsByClassroom(Long classroomId);
    void createAssignment(Long classroomId, Assignment assignment);


}
