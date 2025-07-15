package com.example.AiRepoScrening.Dto.Request;

import com.example.AiRepoScrening.Model.Classroom;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

public class TeacherReqDto {

    private  String name;

    private  String email;

    private String password;

}
