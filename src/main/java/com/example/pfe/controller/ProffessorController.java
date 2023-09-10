package com.example.pfe.controller;

import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Student;
import com.example.pfe.entity.Team;
import com.example.pfe.repos.ProfessorRepos;
import com.example.pfe.service.ProffesorService;
import com.example.pfe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proffesor")
public class ProffessorController {
    @Autowired
    ProffesorService proffesorService;

    @PostMapping("/add")
    public Professor addProffesor(@RequestBody Professor professor){
        return  proffesorService.addProffesor(professor);
    }

    @GetMapping("/GetMyTeams/{id_proffesor}")
    public List<Team> getMyTeams(@PathVariable("id_proffesor") Integer id_proffesor){
        return proffesorService.getProfTeams(id_proffesor);
    }
}
