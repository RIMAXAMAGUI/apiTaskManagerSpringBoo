package com.mdice.apitaskmanager.validator.validations;

import com.mdice.apitaskmanager.exceptions.ToDoExceptions;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.ChainValidator;
import org.springframework.http.HttpStatus;

public class TitleNotNullVaidation extends ChainValidator {

    public void validate(TaskInDTO taskInDTO){
        if (taskInDTO.getTitle().length() == 0  || taskInDTO.getTitle() == null ){
            throw  new ToDoExceptions("Por favor  ingrese un titulo", HttpStatus.BAD_REQUEST);
        }

        this.next.validate(taskInDTO);
    }

}
