package com.mdice.apitaskmanager.persistence.repositoy;

import com.mdice.apitaskmanager.persistence.entity.Task;
import com.mdice.apitaskmanager.persistence.entity.TaskStatus;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Jpa tiene un metodo para crear y para obtener
public interface TaskRepository extends JpaRepository <Task, Long> {

    //Definiendo el metodo que ayudará con una consulta jpql traer las tareas por un parametro de la lista findAllBy, para obtener una tarea por el id = x, sería utilizar lo mismo pero utilizar taskId.
    public List<Task> findAllByTaskStatus(TaskStatus status);

    //Metodo para actualizar y marcar como completada una tarea sin que devuelva nada
    @Modifying //query de actualización y marcar en el servicio que es transaccional
    @Query(value = "UPDATE task SET Task.completed = TRUE , task.finalization_Date = CURRENT_TIMESTAMP  WHERE id=:id", nativeQuery = true)
    public void markTaskAsCompleted(@Param("id") Long id);

    @Modifying //query de actualización y marcar en el servicio que es transaccional
    @Query(value = "UPDATE task SET Task.title = :title, Task.description = :description  WHERE id=:id", nativeQuery = true)
    public void updateTask(@Param("id") Long id, @Param("title") String title, @Param("description") String description);

    @Modifying //query de actualización y marcar en el servicio que es transaccional
    @Query(value = "UPDATE task SET Task.completed = FALSE , task.finalization_Date = NULL  WHERE id=:id", nativeQuery = true)
    public void markTaskAsUnCompleted(@Param("id") Long id);


}   //Metodo para actualizar datos de una tarea


