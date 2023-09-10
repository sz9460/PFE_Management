package com.example.pfe.service;

import com.example.pfe.entity.Compte;
import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Role;
import com.example.pfe.entity.Student;
import com.example.pfe.repos.CompteRepos;
import com.example.pfe.repos.ProfessorRepos;
import com.example.pfe.repos.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {
    @Autowired
    CompteRepos compteRepos;
    @Autowired
    StudentRepos studentRepos;

    @Autowired
    ProfessorRepos professorRepos;

    public Compte addCompte(Compte compte){
        Compte compte1 = new Compte();
        compte1.setEmail(compte.getEmail());
        compte1.setPassword(compte.getPassword());
        if(compte.getRole().toString().equals("Student")){
            Student student = studentRepos.getStudentByEmail(compte.getEmail());
            compte1.setRole(Role.Student);
            compte1.setStudent(student);
            compte1 = compteRepos.save(compte1);
            student.setCompte(compte1);
            studentRepos.save(student);
        } else if (compte.getRole().toString().equals("Professor")) {
            Professor professor = professorRepos.getProfessorByEmail(compte.getEmail());
            compte1.setRole(Role.Professor);
            compte1.setProfessor(professor);
            compte1 = compteRepos.save(compte1);
            professor.setCompte(compte1);
            professorRepos.save(professor);
        }
        return compte1;
    }
}
