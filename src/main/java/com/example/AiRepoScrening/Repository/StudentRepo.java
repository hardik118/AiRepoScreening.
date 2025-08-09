package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    List<Student> findByClassroom_Id(Long Id);




}
