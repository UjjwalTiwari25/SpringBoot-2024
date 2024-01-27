package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${db.username}")
    private String username;

    @Autowired
    private DbConfig dbConfig;

    @GetMapping(path = "hello")
    public String hello(){
        return username;
    }

    @GetMapping(path = "config")
    public DbConfig config(){
        return dbConfig;
    }

}
