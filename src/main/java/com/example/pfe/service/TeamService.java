package com.example.pfe.service;

import com.example.pfe.entity.*;
import com.example.pfe.repos.*;
import com.example.pfe.requestes.AddProfToTeamRequest;
import com.example.pfe.requestes.ChooseProjectRequest;
import com.example.pfe.requestes.GroupSubjectRequest;
import com.example.pfe.requestes.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepos teamRepos;
    @Autowired
    StudentRepos studentRepos;
    @Autowired
    ProfessorRepos professorRepos;

    @Autowired
    ProjectRepos projectRepos;

    @Autowired
    GroupSubjectPriorityRepos groupSubjectPriorityRepos;

    @Autowired
    SubjectAllocationRepos subjectAllocationRepos;
    public Team addTeam(TeamRequest teamRequest){
        Team team = new Team();
        team.setName(teamRequest.getName());
        team = teamRepos.save(team);
        Double somme = 0.0;
        for ( String email : teamRequest.getStudents_emails()) {
            Student student = studentRepos.getStudentByEmail(email);
            student.setTeam(team);
            somme=somme+student.getNote();
            studentRepos.save(student);
        }
        team.setClassement(teamRequest.getClassement());

        team.setNoteAVG(somme/teamRequest.getStudents_emails().size());
        return teamRepos.save(team);
    }
    public  Team AddProfToTeam(Integer id , AddProfToTeamRequest request){
        Professor professor = professorRepos.getProfessorByEmail(request.getEmail());
        if(teamRepos.findById(id).isPresent()) {
            Team team = teamRepos.findById(id).get();
            team.setProfessor(professor);
           return teamRepos.save(team);

        }
        return  null;
    }

    public List<Student> getStudents(Integer id){
        List<Student> students = new ArrayList<>();
        if (teamRepos.findById(id).isPresent()){
            students = teamRepos.findById(id).get().getStudents();
        }
        return students;
    }

    public ChooseProjectRequest chooseProjects(Integer idTeam, ChooseProjectRequest chooseProjectRequest){
        for ( GroupSubjectRequest groupSubjectRequest : chooseProjectRequest.getProjectChoosen()){
            GroupSubjectPriority groupSubjectPriority = new GroupSubjectPriority();
            groupSubjectPriority.setTeam(teamRepos.findById(idTeam).get());
            groupSubjectPriority.setProject(projectRepos.findById(groupSubjectRequest.getIdProject()).get());
            groupSubjectPriority.setPriority(groupSubjectRequest.getPriority());

            groupSubjectPriorityRepos.save(groupSubjectPriority);
        }
        return chooseProjectRequest;

    }

    public int allocateSubjects(){
        List<Team> teams = teamRepos.findAll();
        List<Project> projects = projectRepos.findAll();
        //Initialize allocations
        List<Project> unallocatedProjects = new ArrayList<>(projects);
        //Initialiaze allocations
        List<SubjectAllocation> allocations= new ArrayList<>();
         while (!unallocatedProjects.isEmpty()){
             Project project = unallocatedProjects.remove(0);//select a free subject
             // Retrieve all groupSubjectPriorities for this subject
             List<GroupSubjectPriority> subjectPriorities = groupSubjectPriorityRepos.findByProject(project);
             // Sort groupPriorities by priority descending and group ranking ascending

             subjectPriorities.sort(new Comparator<GroupSubjectPriority>() {
                 @Override
                 public int compare(GroupSubjectPriority gp1, GroupSubjectPriority gp2) {
                     int priorityComparison = Integer.compare(gp2.getPriority(), gp1.getPriority()); // Sort by priority descending
                     if (priorityComparison != 0) {
                         return priorityComparison;
                     }
                     // If priorities are equal, compare by group ranking ascending
                     return Integer.compare(gp1.getTeam().getClassement(), gp2.getTeam().getClassement());
                 }
             });

             for(GroupSubjectPriority groupPreference:subjectPriorities){
             Team team = groupPreference.getTeam();
             if(!groupIsAlloacated(team,allocations)){
                 SubjectAllocation subjectAllocation = new SubjectAllocation();
                 subjectAllocation.setTeam(team);
                 subjectAllocation.setProject(project);
                 subjectAllocationRepos.save(subjectAllocation);
                 allocations.add(subjectAllocation);

                 break;
             }
             }

         }
        System.out.println(allocations.size());
         return allocations.size();

    }

    public boolean groupIsAlloacated(Team team,List<SubjectAllocation> allocations){
        return allocations.stream().anyMatch(allocation -> allocation.getTeam().equals(team));
    }


}
