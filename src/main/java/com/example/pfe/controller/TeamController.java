package com.example.pfe.controller;

import com.example.pfe.entity.Student;
import com.example.pfe.entity.SubjectAllocation;
import com.example.pfe.entity.Team;
import com.example.pfe.repos.StudentRepos;
import com.example.pfe.repos.TeamRepos;
import com.example.pfe.requestes.AddProfToTeamRequest;
import com.example.pfe.requestes.ChooseProjectRequest;
import com.example.pfe.requestes.TeamRequest;
import com.example.pfe.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @Autowired
    TeamRepos teamRepos;
    @Autowired
    StudentRepos studentRepos;
    @PostMapping("/add")
    public Team addTeam(@RequestBody TeamRequest teamRequest){
        return  teamService.addTeam(teamRequest);}

    @PostMapping("/addProfToTeam/{id}")
    public  Team addProfToteam(@PathVariable ("id") Integer id, @RequestBody AddProfToTeamRequest request){
        return  teamService.AddProfToTeam(id,request);
    }
    @GetMapping("/getTeamMumbers/{id}")
    public List<Student> getStudents(@PathVariable("id") Integer id){
       return teamService.getStudents(id);
    }

    @PostMapping("/chooseProject/{idTeam}")
    public ChooseProjectRequest chooseProject(@PathVariable("idTeam") Integer idTeam, @RequestBody ChooseProjectRequest chooseProjectRequest){
        return teamService.chooseProjects(idTeam,chooseProjectRequest);
    }

    @GetMapping("/getAllocations")
    public  int getAllocations(){
        return teamService.allocateSubjects();
    }


}
