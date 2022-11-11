package com.mdice.apitaskmanager.validator;

import com.mdice.apitaskmanager.service.dto.TaskInDTO;

abstract public class ChainValidator {
    public ChainValidator next;

    public void setNext(ChainValidator next) {
        this.next = next;
    }


    public void validate(TaskInDTO taskInDTO){}
}
