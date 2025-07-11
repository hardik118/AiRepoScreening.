package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Submissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<Submissions, Long> {
}
