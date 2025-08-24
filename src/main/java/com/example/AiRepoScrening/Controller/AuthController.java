package com.example.AiRepoScrening.Controller;


import com.example.AiRepoScrening.Auth.AuthReponseDto;
import com.example.AiRepoScrening.Auth.JwtUtil;
import com.example.AiRepoScrening.Auth.UserRole;
import com.example.AiRepoScrening.Dto.Request.LoginReqDto;
import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Request.TeacherReqDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;
import com.example.AiRepoScrening.Dto.Response.TeacherResDto;
import com.example.AiRepoScrening.Service.StudentService;
import com.example.AiRepoScrening.Service.TeacherService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/api/main/auth")
public class AuthController {

    private final TeacherService teacherService;
    private  final StudentService studentService;


    private AuthReponseDto authReponseDto;
    @Autowired
    private JwtUtil jwtUtil;


    public AuthController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }


    //1- signup
    @PostMapping("/signup")
    public ResponseEntity<?> teacherSignup(@RequestBody TeacherReqDto teacherReqDto,
                                                         HttpServletResponse response) {
        // Create teacher
        try{
        TeacherResDto teacher = teacherService.signup(teacherReqDto);

        // Generate JWT
        String token = jwtUtil.generateToken(teacher.getId(), "teacher");

        // Attach JWT as cookie
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        response.addCookie(cookie);

        // Build response DTO
        AuthReponseDto authResponse = new AuthReponseDto(teacher.getId(),token, UserRole.Teacher);

        return ResponseEntity.ok(authResponse);
        }
        catch (RuntimeException ex) {
            // Handles your "email already registered" error
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Something went wrong"));
        }
    }


    //2-login

    @PostMapping("teacher/login")
    public ResponseEntity<?> Teacherlogin(@RequestBody LoginReqDto loginReqDto,HttpServletResponse response) {
        try{
        TeacherResDto teacher = teacherService.login(loginReqDto.getEmail(), loginReqDto.getPassword());

        // Generate JWT
        String token = jwtUtil.generateToken(teacher.getId(), "teacher");

        // Attach JWT as cookie
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        response.addCookie(cookie);

        // Build response DTO
        AuthReponseDto authResponse = new AuthReponseDto(teacher.getId(), token, UserRole.Teacher);

        return ResponseEntity.ok(authResponse);
    }
        catch (RuntimeException ex) {
            // Handles your "email already registered" error
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Something went wrong"));
        }

    }

    @PostMapping("/student/signup/{classroomId}")
    public ResponseEntity<?> signup(@PathVariable Long classroomId, @RequestBody StudentReqDto studentReqDto,HttpServletResponse response) {
        StudentResDto student = studentService.signup(classroomId, studentReqDto);
try{
        // Generate JWT
        String token = jwtUtil.generateToken(student.getId(), "student");

        // Attach JWT as cookie
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        response.addCookie(cookie);

        // Build response DTO
        AuthReponseDto authResponse = new AuthReponseDto(student.getId(), token, UserRole.Student);

        return ResponseEntity.ok(authResponse);

    } catch (RuntimeException ex) {
            // Handles your "email already registered" error
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Something went wrong"));
        }
    }

    // 2. Login
    @PostMapping("/student/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDto loginDto, HttpServletResponse response) {
       try{ StudentResDto student = studentService.login(loginDto.getEmail(), loginDto.getPassword());


        // Generate JWT
        String token = jwtUtil.generateToken(student.getId(), "teacher");

        // Attach JWT as cookie
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        response.addCookie(cookie);

        // Build response DTO
        AuthReponseDto authResponse = new AuthReponseDto(student.getId(), token, UserRole.Student);

        return ResponseEntity.ok(authResponse);

    } catch (RuntimeException ex) {
            // Handles your "email already registered" error
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Something went wrong"));
        }
    }



}
