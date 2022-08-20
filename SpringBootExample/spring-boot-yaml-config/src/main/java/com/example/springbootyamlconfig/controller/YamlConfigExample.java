package com.example.springbootyamlconfig.controller;

import com.example.springbootyamlconfig.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YamlConfigExample {
    @Autowired
    private Person person;

    @RequestMapping("/yaml")
    public Person personInfo(){
        return person;
    }
}
