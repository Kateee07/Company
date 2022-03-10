package com.company.demo.Repositories;

import com.company.demo.Entity.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends JpaRepository<WorkPosition, Integer> {

    @Query(value = "select * from WorkPosition", nativeQuery = true)
    List<WorkPosition> findAllPosition();

    @Query(value = "select POSITION_ID from WORK_POSITION", nativeQuery = true)
    List<Integer> findIdPosition();

    @Query(value = "select * from WorkPosition p where p.id= :id", nativeQuery = true)
    WorkPosition findByIDPosition(@Param("id") int id);


}
