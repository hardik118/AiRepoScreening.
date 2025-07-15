package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.SubmissionReqDto;
import com.example.AiRepoScrening.Dto.Response.SubmissionResDto;
import com.example.AiRepoScrening.Model.Submissions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {
    //Response handling

    Submissions toEntity(SubmissionResDto dto);
    SubmissionResDto toDto(Submissions submissions);

    // Req handling

    Submissions toRequestDto(SubmissionReqDto dto);

    SubmissionReqDto fromRequestDto(Submissions submissions);

}
