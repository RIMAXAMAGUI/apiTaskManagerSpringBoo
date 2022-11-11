package com.mdice.apitaskmanager;

import com.mdice.apitaskmanager.service.dto.TaskInDTO;
import com.mdice.apitaskmanager.validator.ChainValidator;
import com.mdice.apitaskmanager.validator.validations.TitleNotNullVaidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiTaskManagerApplicationTests {

    private ChainValidator titleNotNullValidation;

    @BeforeEach
    public void setup(){
        titleNotNullValidation = new TitleNotNullVaidation();
    }
    @Test
    public void contextLoads() {

    }
    @Test
    public void contextLoadsfails() {

    }


}
