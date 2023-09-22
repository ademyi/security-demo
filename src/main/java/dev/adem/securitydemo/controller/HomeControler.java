package dev.adem.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {
    @GetMapping
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/user")
    public String user(){
        return "Hello, User!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello, Admin!";
    }

}
