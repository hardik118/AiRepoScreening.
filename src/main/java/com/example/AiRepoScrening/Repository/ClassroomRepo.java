package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClassroomRepo  extends JpaRepository<Classroom, Long> {
}
