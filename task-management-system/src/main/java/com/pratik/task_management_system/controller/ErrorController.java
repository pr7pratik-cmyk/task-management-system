package com.pratik.task_management_system.controller;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.GetMapping;

@ReadingConverter
public class ErrorController {
    @GetMapping("/error")
    public String Error(){
        return "Something went wrong!";
    }
}
