package com.example.pfe.controller;
import com.example.pfe.entity.Project;
import com.example.pfe.requestes.ProjectRequest;
import com.example.pfe.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/add")
    public Project addProject(@RequestBody ProjectRequest projectRequest){
        return  projectService.addProject(projectRequest);
    }

    @GetMapping("/getProjects/{idprof}")
    public List<Project> getProjects(@PathVariable("idprof") Integer idprof){
        return projectService.getProjectOfProfessor(idprof);
    }

}
