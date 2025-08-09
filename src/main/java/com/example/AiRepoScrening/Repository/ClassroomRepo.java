package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Assignments;
import com.example.AiRepoScrening.Model.Classroom;
import com.example.AiRepoScrening.Model.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ClassroomRepo  extends JpaRepository<Classroom, Long> {
    @EntityGraph(attributePaths = {"teacher"})
    Optional<Classroom> findByUniqueId(Long uniqueId);
    Optional<Classroom> findByTeacherId(Long teacherId);


}
