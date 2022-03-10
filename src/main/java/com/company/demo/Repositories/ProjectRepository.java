package com.company.demo.Repositories;

import com.company.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "select e from Project e where e.id= :id")
    Project findProjectById(@Param("id") int id);

    @Query(value = "SELECT* FROM Project e WHERE e.status_id=2", nativeQuery = true)
    List<Project> getFinishedProjects();

    @Query(value = "SELECT* FROM Project e WHERE e.status_id!=2", nativeQuery = true)
    List<Project> getActualProjectList();

    @Query(value = "SELECT * FROM Project", nativeQuery = true)
    List<Project> getAllProjects();

}



