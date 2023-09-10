package com.example.pfe.repos;
import com.example.pfe.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepos extends JpaRepository<Project,Integer> {
    Project getByTitle(String title);
}
