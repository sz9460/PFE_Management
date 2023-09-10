package com.example.pfe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id_project;
    public String domain;
    public String title;
    public String description;

    @ManyToOne
    @JoinColumn(name="id_Professor")
    private Professor professor;

    /*@ManyToMany(mappedBy = "projectsChoosen")
    @JsonIgnore
    private List<Team> teams;*/

    @OneToMany(mappedBy = "project")
    private List<GroupSubjectPriority> groupSubjectPriorities;

    @OneToOne(mappedBy = "project")
    private SubjectAllocation subjectAllocation;

}
