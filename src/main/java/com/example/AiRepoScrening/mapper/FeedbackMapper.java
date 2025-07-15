package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.FeedbackReqDto;
import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Model.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    //Response handlers
    FeedbackResDto toDto(Feedback feedback);
    Feedback toEntity(FeedbackResDto dto);

    // Request handling
    Feedback toRequestDto(FeedbackReqDto dto);
    FeedbackReqDto toRequestDto(Feedback feedback);


}
