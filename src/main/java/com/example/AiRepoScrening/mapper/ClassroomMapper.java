package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.ClassroomReqDto;
import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Model.Classroom;
import com.example.AiRepoScrening.Model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    //Response handling
    Classroom toEntity(ClassroomResDto dto);
    ClassroomResDto toDto(Classroom classroom);

    //Request handling
    Classroom toRequestDto(StudentReqDto studentReqDto);
    ClassroomReqDto fromRequestDto(Student student);


}
