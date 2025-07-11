package com.example.AiRepoScrening.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  Integer score;


    @Column(length = 1000)
    private  String comment;

    @OneToOne
    @JoinColumn(name = "submissionId")
    private Submissions submissions;

}
