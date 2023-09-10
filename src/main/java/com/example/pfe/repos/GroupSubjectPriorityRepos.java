package com.example.pfe.repos;
import com.example.pfe.entity.GroupSubjectPriority;
import com.example.pfe.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupSubjectPriorityRepos extends JpaRepository<GroupSubjectPriority, Integer> {
    List<GroupSubjectPriority> findByProjectOrderByPriorityDesc(Project project);
    List<GroupSubjectPriority> findByProject(Project project);
}
