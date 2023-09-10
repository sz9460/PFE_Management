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
public class Compte {
    @Id
    @GeneratedValue
    private Integer id_compte;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "compte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;
    @OneToOne(mappedBy = "compte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Professor professor;
}
