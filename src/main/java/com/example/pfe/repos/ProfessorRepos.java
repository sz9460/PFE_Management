package com.example.pfe.repos;

import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Project;
import com.example.pfe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepos extends JpaRepository<Professor,Integer> {
    Professor getProfessorByEmail(String email);
}
