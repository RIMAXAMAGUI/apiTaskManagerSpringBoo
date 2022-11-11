package com.mdice.apitaskmanager.validator.validations;

import com.mdice.apitaskmanager.exceptions.ToDoExceptions;
import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.ChainValidator;
import org.springframework.http.HttpStatus;

public class TitleLongValidation extends ChainValidator {
    @Override
    public void validate(TaskInDTO taskInDTO){
        if(taskInDTO.getTitle().length() > 25 ){
            throw new ToDoExceptions("Titulo demasiado largo" , HttpStatus.BAD_REQUEST);
        }

        this.next.validate(taskInDTO);
    }
}
