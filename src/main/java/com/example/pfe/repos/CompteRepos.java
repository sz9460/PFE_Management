package com.example.pfe.repos;

import com.example.pfe.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepos extends JpaRepository<Compte,Integer> {
}
