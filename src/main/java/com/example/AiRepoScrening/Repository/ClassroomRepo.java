package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ClassroomRepo  extends JpaRepository<Classroom, Long> {
    Optional<Classroom> findByclassroomId(Long Id);
    Optional<Classroom> findByTeacherId(Long teacherId);

}
