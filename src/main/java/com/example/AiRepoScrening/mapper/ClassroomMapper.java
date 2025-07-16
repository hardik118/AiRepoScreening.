package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.ClassroomReqDto;
import com.example.AiRepoScrening.Dto.Request.StudentReqDto;
import com.example.AiRepoScrening.Dto.Response.ClassroomResDto;
import com.example.AiRepoScrening.Model.Classroom;
import com.example.AiRepoScrening.Model.Student;
import lombok.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    //Response handling
    Classroom toEntity(ClassroomResDto dto);
    ClassroomResDto toDto(Classroom classroom);

    //Request handling
    Classroom fromRequestDto(ClassroomReqDto classroomReqDto);
    ClassroomReqDto toRequestDto(Classroom classroom);


}
