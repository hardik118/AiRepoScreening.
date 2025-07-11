package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeacherRepo  extends JpaRepository<Teacher, Long> {
}
