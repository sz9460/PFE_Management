package com.example.pfe.controller;

import com.example.pfe.entity.Compte;
import com.example.pfe.entity.Student;
import com.example.pfe.service.CompteService;
import com.example.pfe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compte")
public class CompteController {
    @Autowired
    CompteService compteService;
    @PostMapping("/add")
    public Compte addCompte(@RequestBody Compte compte){
        return  compteService.addCompte(compte);
    }
}
