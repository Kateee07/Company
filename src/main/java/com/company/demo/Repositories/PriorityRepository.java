package com.company.demo.Repositories;

import com.company.demo.Entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Integer> {

    @Query(value = "select * from PRIORITY", nativeQuery = true)
    List<Priority> findAllPosition();

    @Query(value = "select ID from PRIORITY", nativeQuery = true)
    List<Integer> findAllIdPosition();
}
