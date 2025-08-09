package com.example.AiRepoScrening.Service;

import com.example.AiRepoScrening.Dto.Request.AssignmentReqDto;
import com.example.AiRepoScrening.Dto.Request.ClassroomReqDto;
import com.example.AiRepoScrening.Dto.Request.TeacherReqDto;
import com.example.AiRepoScrening.Dto.Response.*;
import com.example.AiRepoScrening.Model.*;
import com.example.AiRepoScrening.Repository.*;
import com.example.AiRepoScrening.Service.Impl.TeacherServiceImpl;
import com.example.AiRepoScrening.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService  implements TeacherServiceImpl {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private ClassroomRepo classroomRepo;


    @Autowired
    private ClassroomMapper classroomMapper;


    @Autowired
    private AssignmentMapper assignmentMapper;

    @Autowired
    private AssignmentRepo assignmentRepo;


    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private  StudentRepo studentRepo;

    @Autowired
    private StudentMapper studentMapper;

    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);





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
                orElseThrow(()->new RuntimeException("user doesn't exists  "));

        return teacherMapper.toDto(teacherToExists);
    }

    @Override
    public  void createClassroom(Long teacherId, ClassroomReqDto classroomReqDto){
        Optional<Teacher> teacherToExists = teacherRepo.findById(teacherId);
        System.out.println(teacherToExists+" id "+teacherId);

        if(teacherToExists.isEmpty()) throw new RuntimeException("Teacher does not exists");
        logger.info("Teacher found: {} with ID: {}", teacherToExists.get(), teacherId);


        Classroom classroom =  classroomMapper.fromRequestDto(classroomReqDto);

        Optional<Classroom> existingClassroom = classroomRepo.findByTeacherId(teacherId);

        if (existingClassroom.isPresent()) {
            throw new RuntimeException("Classroom already exists. Cannot create more than one classroom.");
        }

        classroom.setTeacher(teacherToExists.get());

        classroomRepo.save(classroom);
        return;
    }
    @Override
    public  ClassroomResDto viewClassroom(Long  uniqueClassroomId){

        Classroom classroomToExists= classroomRepo.findByUniqueId(uniqueClassroomId)
                .orElseThrow(()->new RuntimeException("classroom doesn't exists: invalid operation."));

        logger.info("Classroom object from db before mapping to resDto {}", classroomToExists);


        return  classroomMapper.toDto(classroomToExists);


    }

    @Override
    public  void createAssignment(Long teacherId, AssignmentReqDto assignmentReqDto){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Classroom classroom = classroomRepo.findById(assignmentReqDto.getClassroomId())
                .orElseThrow(() -> new RuntimeException("Classroom does not exist"));


        Assignments assignments = assignmentMapper.fromRequestDto(assignmentReqDto);
        // Set the teacher and classroom manually
        assignments.setCreatedBy(teacherToExists);
        assignments.setClassroom(classroom);
        assignmentRepo.save(assignments);

        return;

    }

    @Override
    public List<SubmissionResDto> viewSubmissions(Long teacherId, Long assignmentId){
        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Assignments assignmentsToExists= assignmentRepo.findById(assignmentId)
                .orElseThrow(()->new RuntimeException("No assignment for such id req exists"));


        List<Submissions> submissionsList= submissionRepo.findAllByAssignments_Id(assignmentId);

        return submissionsList.stream()
                .map(submissionMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public  List<StudentResDto> viewStudents(Long teacherId, Long classroomId){

        Teacher teacherToExists = teacherRepo.findById(teacherId).
                orElseThrow(()->new RuntimeException("Teacher  doesn't exists  "));

        Classroom classroomToExists= classroomRepo.findById(classroomId)
                .orElseThrow(()->new RuntimeException("classroom doesn't exists: invalid operation."));

        List<Student> studentList= studentRepo.findByClassroom_Id(classroomId);

        return studentList.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());


    }

    @Override
    public List<AssignmentResDto> viewClassroomAssignments(Long classroomId){


        Classroom classroomToExists= classroomRepo.findById(classroomId)
                .orElseThrow(()->new RuntimeException("classroom doesn't exists: invalid operation."));

        List<Assignments> assignmentsList= assignmentRepo.findAllByClassroomId(classroomId);

        return assignmentsList.stream()
                .map(assignmentMapper::toDto)
                .collect(Collectors.toList());


    }








}
