package com.mdice.apitaskmanager.service;

import com.mdice.apitaskmanager.exceptions.ToDoExceptions;
import com.mdice.apitaskmanager.mapper.TaskInDTOToTask;
import com.mdice.apitaskmanager.persistence.entity.Task;
import com.mdice.apitaskmanager.persistence.entity.TaskStatus;
import com.mdice.apitaskmanager.persistence.repositoy.TaskRepository;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    //Definiendo la logic para obtener losdatos del mapper para el servicio de tareas
    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //logica para obtener una tarea (requiere crear un metodo dentro del repositorio)
    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    //logica para obtener todas las tareas, además este metodo no es necesario crearlo en el repositorio porque esta por defecto dentro del jpa
    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public Task getById(long id) {
        Optional<Task> optionalTask = this.repository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("id not found", HttpStatus.NOT_FOUND);
        }

        return optionalTask.get();
    }

    //logica para obtener tareas por un estado de tarea determinado (requiere crear el metodo dentro del repositorio)
    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsCompleted(Long id) {
        //implementamos la excepción to do excepcion
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("id not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsCompleted(id);
    }

    @Transactional
    public void updateTaskAsUnCompleted(Long id) {
        //implementamos la excepción to do excepcion
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("id not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsUnCompleted(id);
    }

    //Eliminar una tarea
    public void deleteTaskById(Long id) {
        //implementamos la excepción to do excepcion
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("id not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

    @Transactional
    public void updateTask(Long id, String title, String description) {
        //implementamos la excepción to do excepcion
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("id not found", HttpStatus.NOT_FOUND);
        }
        this.repository.updateTask(id, title, description);
    }

    @Transactional
    public Task updateTaskTwo(Long id, TaskInDTO taskInDTO) {

        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("id not found", HttpStatus.NOT_FOUND);
        }

        Task task = optionalTask.get();

        task.setTitle(taskInDTO.getTitle());
        task.setDescription(taskInDTO.getDescription());
        repository.save(task);
        return task;
    }
}



