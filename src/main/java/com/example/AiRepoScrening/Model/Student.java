package com.example.AiRepoScrening.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false, unique = true)
    private  String email;

    @Column(nullable = false)
    @Size(min = 6, max = 16, message = "password length need to be between 6 and 16 char")
    private String password;

    @ManyToOne
    @JoinColumn(name = "classRoomId")
    private Classroom classroom;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Submissions> submissions;



}
