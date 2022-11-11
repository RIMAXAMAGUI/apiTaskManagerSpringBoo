package com.mdice.apitaskmanager.validator.validations;

import com.mdice.apitaskmanager.exceptions.ToDoExceptions;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.ChainValidator;
import org.springframework.http.HttpStatus;

public class DescriptionNotNullValidation extends ChainValidator {
    @Override

    public void validate(TaskInDTO taskInDTO){
        if(taskInDTO.getDescription().length() == 0 || taskInDTO.getDescription() == null){
            throw new ToDoExceptions("No tiene descripcion", HttpStatus.BAD_REQUEST);
        }
        this.next.validate(taskInDTO);
    }
}
