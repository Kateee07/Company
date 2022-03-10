package com.company.demo.Services;

import com.company.demo.Entity.WorkPosition;
import com.company.demo.Repositories.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;


    public WorkPosition save(WorkPosition position){
        return positionRepository.save(position);

    }
    public List<WorkPosition> showAll(){
        return positionRepository.findAllPosition();
    }
}
