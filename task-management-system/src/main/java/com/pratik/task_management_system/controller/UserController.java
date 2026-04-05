package com.pratik.task_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    public String helloUser(){
        return "Hello User";
    }
    @GetMapping("/test")
    public String test() {
        return "User API working";
    }
}
