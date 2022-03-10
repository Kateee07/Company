package com.company.demo.DTO;

import com.company.demo.Entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectDTO projectDTO) {
        Project project=new Project();
        return project;
    }

    public ProjectDTO toDTO(Project project) {
     ProjectDTO projectDTO=new ProjectDTO(project);
        return projectDTO;
    }
}

