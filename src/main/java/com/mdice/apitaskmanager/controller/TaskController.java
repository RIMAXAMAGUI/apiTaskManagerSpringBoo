package com.mdice.apitaskmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }
}
