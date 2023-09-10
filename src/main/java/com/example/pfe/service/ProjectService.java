package com.example.pfe.service;

import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Project;
import com.example.pfe.repos.ProfessorRepos;
import com.example.pfe.repos.ProjectRepos;
import com.example.pfe.requestes.ProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepos projectRepos;

    @Autowired
    ProfessorRepos professorRepos;

    public Project addProject(ProjectRequest projectRequest){
        Project project = new Project();
        project.setDescription(projectRequest.getDescription());
        project.setDomain(projectRequest.getDomain());
        project.setTitle(projectRequest.getTitle());
        project.setProfessor(professorRepos.findById(projectRequest.getId_professor()).get());
        return projectRepos.save(project);
    }

    public List<Project> getProjectOfProfessor(Integer idProf){
        Professor professor = professorRepos.findById(idProf).get();
        return professor.getProjects();
    }
}
