package com.company.demo.Repositories;

import com.company.demo.Entity.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorktimeRepository extends JpaRepository<WorkTime, Integer> {
}
