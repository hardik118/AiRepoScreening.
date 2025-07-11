package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

}
