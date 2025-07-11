package com.example.AiRepoScrening.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assignments")
public class Assignments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private  String title;

    @Column(length = 5000)
    private String description;

    private LocalDateTime deadLine;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Teacher created_by;

    @OneToMany(mappedBy = "assignments", cascade = CascadeType.ALL)
    private List<Submissions> submissions;

}
