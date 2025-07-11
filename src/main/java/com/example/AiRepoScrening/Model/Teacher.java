package com.example.AiRepoScrening.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")

public class Teacher {

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

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Classroom classroom;

}
