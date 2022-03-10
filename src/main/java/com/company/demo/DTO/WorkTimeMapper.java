package com.company.demo.DTO;

import com.company.demo.Entity.WorkTime;
import org.springframework.stereotype.Component;

@Component
public class WorkTimeMapper {
    public WorkTime toEntity(WorkTimeDTO workTimeDTO) {
        WorkTime workTime = new WorkTime();
        return workTime;
    }

    public WorkTimeDTO workTimeDTO(WorkTime workTime) {
        WorkTimeDTO workTimeDTO = new WorkTimeDTO(workTime);
        return workTimeDTO;
    }
}
