package com.mdice.apitaskmanager.validator;


import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.validations.TitleNotNullVaidation;

public class WebTaskValidator {
    private ChainValidator titleNotNullVaidation = new TitleNotNullVaidation();

    public void WebTaskValidator(TaskInDTO taskInDTO){


    }

}
