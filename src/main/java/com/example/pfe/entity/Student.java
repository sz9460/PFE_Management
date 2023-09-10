package com.example.pfe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id_student;
    private  String firstName;
    private  String LastName;
    private Double Note;
    private String email;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    private Boolean isLeader;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compte")
    @JsonIgnore
    private Compte compte;
    @ManyToOne
    @JoinColumn(name="id_team")
    private Team team;
}
