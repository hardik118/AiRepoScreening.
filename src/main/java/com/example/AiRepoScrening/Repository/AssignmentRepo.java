package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssignmentRepo extends JpaRepository<Assignments, Long> {
}
