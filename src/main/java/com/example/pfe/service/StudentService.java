package com.example.pfe.service;

import com.example.pfe.entity.Professor;
import com.example.pfe.entity.Student;
import com.example.pfe.entity.Team;
import com.example.pfe.repos.ProfessorRepos;
import com.example.pfe.repos.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepos studentRepos;



    public Student addStudent(Student student){
        Student student1 = new Student();
        student1.setEmail(student.getEmail());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setSpeciality(student.getSpeciality());
        student1.setIsLeader(student.getIsLeader());
        student1.setNote(student.getNote());
        return  studentRepos.save(student1);
    }




}
