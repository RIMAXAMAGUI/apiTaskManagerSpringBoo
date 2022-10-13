package com.mdice.apitaskmanager.service;

import com.mdice.apitaskmanager.mapper.TaskInDTOToTask;
import com.mdice.apitaskmanager.persistence.entity.Task;
import com.mdice.apitaskmanager.persistence.repositoy.TaskRepository;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task  = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}
