package com.mdice.apitaskmanager.controller;

import com.mdice.apitaskmanager.persistence.entity.Task;
import com.mdice.apitaskmanager.service.TaskService;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO ){
        return this.taskService.createTask(taskInDTO);

    }
}
