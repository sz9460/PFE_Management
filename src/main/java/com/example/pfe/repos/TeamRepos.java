package com.example.pfe.repos;

import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepos extends JpaRepository<Team,Integer> {
}
