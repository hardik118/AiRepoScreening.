package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Submissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepo extends JpaRepository<Submissions, Long> {
    List<Submissions> findByStudentId(Long studentId);
    List<Submissions> findByAssignmentId(Long assignmentId);
    Optional<Submissions> findByAssignmentIdAndStudentId(Long assignmentId, Long studentId);

}
