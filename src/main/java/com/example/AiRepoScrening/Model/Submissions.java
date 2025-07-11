package com.example.AiRepoScrening.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "submissions")
public class Submissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private  String repoUrl;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private  Student student;

    @ManyToOne
    @JoinColumn(name = "assignmentId")
    private  Assignments assignments;

    @OneToOne(mappedBy = "submissions",cascade = CascadeType.ALL)
    private Feedback feedback;



}
