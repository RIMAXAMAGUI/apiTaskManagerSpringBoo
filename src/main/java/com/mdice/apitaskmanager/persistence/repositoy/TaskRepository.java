package com.mdice.apitaskmanager.persistence.repositoy;

import com.mdice.apitaskmanager.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {

}
