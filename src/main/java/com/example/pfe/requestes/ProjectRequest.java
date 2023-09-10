package com.example.pfe.requestes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectRequest {

    private Integer id_project;
    public String domain;
    public String title;
    public String description;
    private Integer id_professor;
}
