package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.StudentResDto;
import com.example.AiRepoScrening.Model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    //Response handling
    Student toEntity(StudentResDto dto);
    StudentResDto toDto(Student student);

    // request handling
    Student fromRequestDto(StudentReqDto dto);
    StudentReqDto toRequestDto(Student student);



}
