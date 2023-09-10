package com.example.pfe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Professor {
    @Id
    @GeneratedValue
    private Integer id_Professor;
    private  String firstName;
    private  String LastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Grades grade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compte")
    @JsonIgnore
    private Compte compte;

    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Team> teams=new ArrayList<>();


    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Project> projects=new ArrayList<>();


}
