package com.example.AiRepoScrening.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(unique = true, nullable = false)
    private Long uniqueId;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Assignments> assignments ;



}
