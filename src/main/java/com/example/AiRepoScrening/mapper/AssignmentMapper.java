package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.AssignmentReqDto;
import com.example.AiRepoScrening.Dto.Response.AssignmentResDto;
import com.example.AiRepoScrening.Model.Assignments;
import lombok.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    // Res handling

    AssignmentResDto toDto(Assignments assignment);
    Assignments toEntity(AssignmentResDto dto);

    //  request handling
    Assignments fromRequestDto(AssignmentReqDto dto);
    AssignmentReqDto toRequestDto(Assignments assignment);
}
