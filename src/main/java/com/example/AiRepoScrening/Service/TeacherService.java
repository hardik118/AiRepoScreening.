package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Request.AssignmentReqDto;
import com.example.AiRepoScrening.Dto.Request.ClassroomReqDto;
import com.example.AiRepoScrening.Dto.Request.TeacherReqDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;
import com.example.AiRepoScrening.Dto.Response.SubmissionResDto;
import com.example.AiRepoScrening.Dto.Response.TeacherResDto;
import com.example.AiRepoScrening.Model.*;
import com.example.AiRepoScrening.Repository.*;
import com.example.AiRepoScrening.Service.Impl.TeacherServiceImpl;
import com.example.AiRepoScrening.mapper.*;
import org.hibernate.sql.ast.tree.update.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeacherService  implements TeacherServiceImpl {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private ClassroomRepo classroomRepo;

    @Autowired
    private Classroom classroom;

    @Autowired
    private ClassroomMapper classroomMapper;

    @Autowired
    private Assignment assignment;

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private Submissions submissions;

    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private Student student;

    @Autowired
    private  StudentRepo studentRepo;

    @Autowired
    private StudentMapper studentMapper;






    @Override
    public TeacherResDto signup(TeacherReqDto teacherReqDto) {
        Teacher teacher = teacherMapper.fromRequestDto(teacherReqDto);
        Optional<Teacher> teacherToExists = teacherRepo.findByEmail(teacher.getEmail());
        if(teacherToExists.isPresent()) throw new UsernameNotFoundException("user Email is already registered");

        Teacher savedTeacher= teacherRepo.save(teacher);
        return  teacherMapper.toDto(savedTeacher);

    }
    @Override
    public  TeacherResDto login(String email, String password) {

        Teacher teacherToExists = teacherRepo.findByEmail(email).
                orElseThrow(()->new RuntimeException("user email is not registered "));

        if(!teacherToExists.getPassword().equals(password)){
            throw  new RuntimeException(("password is not valid for the registered user"));

        }

        return  teacherMapper.toDto(teacherToExists);

    }
    @Override
    public  TeacherResDto viewProfile(Long teacherId){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("user does't exists  "));

        return teacherMapper.toDto(teacherToExists);
    }

    @Override
    public  void createClassroom(Long teacherId, ClassroomReqDto classroomReqDto){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  does't exists  "));

        Classroom classroom =  classroomMapper.fromRequestDto(classroomReqDto);

        Classroom classroomToExists= classroomRepo.findByTeacherId(teacherId)
                .orElseThrow(()->new RuntimeException("class room already exists cannot create more than 1 classroom invalid operation."));

        Classroom createdClassroom = classroomRepo.save(classroom);
        return;
    }
    @Override
    public  ClassroomResDto viewClassroom(Long  uniqueClassroomId){

        Classroom classroomToExists= classroomRepo.findByUniqueId(uniqueClassroomId)
                .orElseThrow(()->new RuntimeException("classroom doesn't exists: invalid operation."));


       return  classroomMapper.toDto(classroomToExists);


    }

    @Override
    public  void createAssignment(Long teacherId, AssignmentReqDto assignmentReqDto){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Assignments assignments = assignmentMapper.fromRequestDto(assignmentReqDto);

        Assignments assignmentSaved= assignmentRepo.save(assignments);

        return;

    }

    @Override
    public List<SubmissionResDto> viewSubmissions(Long teacherId, Long assignmentId){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Assignments assignmentsToExists= assignmentRepo.findById(assignmentId)
                .orElseThrow(()->new RuntimeException("No assignment for such id req exists"));


        List<Submissions> submissionsList= submissionRepo.findByAssignmentId(assignmentId);

        return submissionsList.stream()
                .map(submissionMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public  List<StudentResDto> viewStudents(Long teacherId, Long classroomId){

        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Classroom classroomToExists= classroomRepo.findByclassroomId(classroomId)
                .orElseThrow(()->new RuntimeException("classroom doesn't exists: invalid operation."));

        List<Student> studentList= studentRepo.findBYClassroomId(classroomId);

        return studentList.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());


    }







}
