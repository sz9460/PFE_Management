package com.example.pfe.repos;

import com.example.pfe.entity.Student;
import com.example.pfe.entity.Team;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepos extends JpaRepository<Student , Integer> {
    Student getStudentByEmail(String email);
    List<Student> findByTeam(Team team);
}
