package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Model.Teacher;
import com.example.AiRepoScrening.Repository.*;
import com.example.AiRepoScrening.Service.Impl.TeacherServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements TeacherServiceIn {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private ClassroomRepo classroomRepo;


    public Teacher registerTeacher(Teacher teacher){



    }

}
