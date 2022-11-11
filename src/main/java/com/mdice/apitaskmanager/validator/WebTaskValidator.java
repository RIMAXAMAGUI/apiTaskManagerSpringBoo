package com.mdice.apitaskmanager.validator;


import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.validations.DescriptionLongValidation;
import com.mdice.apitaskmanager.validator.validations.DescriptionNotNullValidation;
import com.mdice.apitaskmanager.validator.validations.TitleLongValidation;
import com.mdice.apitaskmanager.validator.validations.TitleNotNullVaidation;

public class WebTaskValidator {
    private ChainValidator titleNotNullVaidation = new TitleNotNullVaidation();

    private ChainValidator descrioptionNotNullValidation = new DescriptionNotNullValidation();
    private ChainValidator titleLongValidation = new TitleLongValidation();

    private ChainValidator descriptionLongValidation = new DescriptionLongValidation();

    public void validate(TaskInDTO taskInDTO){
        titleNotNullVaidation.setNext(titleLongValidation);
        titleLongValidation.setNext(descrioptionNotNullValidation);
        descrioptionNotNullValidation.setNext(descriptionLongValidation);

        titleNotNullVaidation.validate(taskInDTO);

    }

}
