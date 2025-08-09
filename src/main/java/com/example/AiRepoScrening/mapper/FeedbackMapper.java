package com.example.AiRepoScrening.mapper;

import com.example.AiRepoScrening.Dto.Request.FeedbackReqDto;
import com.example.AiRepoScrening.Dto.Response.FeedbackResDto;
import com.example.AiRepoScrening.Model.Feedback;
import com.example.AiRepoScrening.Model.Submissions;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    // Mapping FeedbackReqDto to Feedback entity
    @Mappings({
            @Mapping(source = "submissionId", target = "submissions", qualifiedByName = "mapToSubmission"),
            @Mapping(source = "score", target = "score"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(target = "id", ignore = true) // id is typically generated, ignore it
    })
    Feedback fromRequestDto(FeedbackReqDto dto);

    // Mapping Feedback entity to FeedbackReqDto
    @Mappings({
            @Mapping(source = "submissions.id", target = "submissionId"),
            @Mapping(source = "score", target = "score"),
            @Mapping(source = "comment", target = "comment")
    })
    FeedbackReqDto toRequestDto(Feedback feedback);

    // Mapping Feedback entity to FeedbackResDto
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "score", target = "score"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "submissions.id", target = "submissionId")
    })
    FeedbackResDto toDto(Feedback feedback);

    // Mapping FeedbackResDto to Feedback entity
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "score", target = "score"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "submissionId", target = "submissions", qualifiedByName = "mapToSubmission")
    })
    Feedback toEntity(FeedbackResDto dto);

    @Named("mapToSubmission")
    default Submissions mapToSubmission(Long id) {
        if (id == null) return null;
        Submissions submission = new Submissions();
        submission.setId(id);
        return submission;
    }
}

