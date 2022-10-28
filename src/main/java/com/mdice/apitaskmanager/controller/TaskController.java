package com.mdice.apitaskmanager.controller;

import com.mdice.apitaskmanager.persistence.entity.Task;
import com.mdice.apitaskmanager.persistence.entity.TaskStatus;
import com.mdice.apitaskmanager.service.TaskService;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import org.springframework.http.HttpRange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //Inserta toda las tareas
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO ){
        return this.taskService.createTask(taskInDTO);
    }

    //Devuelve todas las tareas
    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    //Devuelve tareas por estado de tarea (leer comentario dentro del TaskService y TaskController para el id)
    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskstatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @GetMapping("/getbyid/{id}")
    public Task getById(@PathVariable("id") long id){
        return this.taskService.getById(id);
    }
    //Actualizaremos una sola tarea y utilizaremos una anotacion pathmapping

    @PatchMapping("mark-as-completed/{id}")
    public ResponseEntity<Void> markTaskAsCompleted(@PathVariable("id") Long id){
        this.taskService.updateTaskAsCompleted(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("mark-as-uncompleted/{id}")
    public ResponseEntity<Void> markTaskAsUnCompleted(@PathVariable("id") Long id){
        this.taskService.updateTaskAsUnCompleted(id);
        return ResponseEntity.noContent().build();
    }
    //Servicio para eliminar tarea
    @DeleteMapping("deleteTask/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping ( "updateTask/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,@RequestBody TaskInDTO taskInDTO){
        this.taskService.updateTask(id, taskInDTO.getTitle(), taskInDTO.getDescription());
        return ResponseEntity.noContent().build();
    }

    @PostMapping ( "updateTaskTwo/{id}")
    public ResponseEntity<Void> updateTwo(@PathVariable("id") Long id,@RequestBody TaskInDTO taskInDTO){
        this.taskService.updateTaskTwo(id, taskInDTO);
        return ResponseEntity.noContent().build();
    }
}
