package com.mdice.apitaskmanager.mapper;

import com.mdice.apitaskmanager.persistence.entity.Task;
import com.mdice.apitaskmanager.persistence.entity.TaskStatus;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper <TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEstimatedDate(in.getEstimatedDate());
        task.setCreateDate(LocalDateTime.now());
        task.setTaskStatus(TaskStatus.ON_TIME);
        task.setCompleted(false);
        return task;
    }
}
