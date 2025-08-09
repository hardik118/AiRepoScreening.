package com.example.AiRepoScrening.Repository;

import com.example.AiRepoScrening.Model.Assignments;
import org.hibernate.sql.ast.tree.update.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AssignmentRepo extends JpaRepository<Assignments, Long> {
    List<Assignments> findAllByClassroomId(Long classroomId);
    List<Assignments> findAllByCreatedBy_Id(Long teacherId);

}
