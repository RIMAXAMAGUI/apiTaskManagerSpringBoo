package com.mdice.apitaskmanager.validator.validations;

import com.mdice.apitaskmanager.exceptions.ToDoExceptions;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.ChainValidator;
import org.springframework.http.HttpStatus;

public class DescriptionLongValidation extends ChainValidator {
    @Override

    public void validate(TaskInDTO taskInDTO){
        if(taskInDTO.getDescription().length() >100){
            throw new ToDoExceptions("la descripcion es demasiado larga ", HttpStatus.BAD_REQUEST);
        }

    }
}
