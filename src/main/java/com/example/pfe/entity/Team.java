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
public class Team {
    @Id
    @GeneratedValue
    private Integer id_team;
    private String name;
    private Double noteAVG;
    private Integer classement;

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="id_Professor")
    private Professor professor;

   /* @ManyToMany
    @JoinTable(name="choose",joinColumns=@JoinColumn(name="id_team"),inverseJoinColumns=@JoinColumn(name="id_project"))
    private List<Project> projectsChoosen;*/

    @OneToMany(mappedBy = "team")
    private List<GroupSubjectPriority> groupSubjectPriorities;

    @OneToOne(mappedBy = "team")
    private SubjectAllocation subjectAllocation;

}
