package com.example.AiRepoScrening.mapper;


import com.example.AiRepoScrening.Dto.Request.TeacherReqDto;
import com.example.AiRepoScrening.Dto.Response.TeacherResDto;
import com.example.AiRepoScrening.Model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    //Res mapping for service layer
    TeacherResDto toDto(Teacher teacher);
    Teacher toEntity(TeacherResDto teacherResDto);


    //Req mapping
    TeacherReqDto toRequestDto(Teacher teacher);
    Teacher fromRequestDto(TeacherReqDto teacherReqDto);




}
