package com.example.pfe.service;

import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Team;
import com.example.pfe.repos.ProfessorRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProffesorService {
    @Autowired
    ProfessorRepos professorRepos;
    public Professor addProffesor(Professor professor){
        Professor professor1 = new Professor();
        professor1.setFirstName(professor.getFirstName());
        professor1.setLastName(professor.getLastName());
        professor1.setGrade(professor.getGrade());
        professor1.setEmail(professor.getEmail());
        return professorRepos.save(professor1) ;
    }
    public List<Team> getProfTeams(Integer id){
        List<Team> teams = new ArrayList<>();
        if(professorRepos.findById(id).isPresent()){
            teams = professorRepos.findById(id).get().getTeams();
        }
        return teams ;
    }
}
