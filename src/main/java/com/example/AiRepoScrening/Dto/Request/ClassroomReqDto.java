package com.example.AiRepoScrening.Dto.Request;

import com.example.AiRepoScrening.Model.Teacher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ClassroomReqDto {
    private  String name;

    private Long uniqueId;

    private Long teacher_id;
}
