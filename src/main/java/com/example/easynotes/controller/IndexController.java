package com.example.easynotes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

//Controller
//@RequestMapping("/")
@Controller
public class IndexController {

    //@GetMapping
    //@ResponseBody
    @RequestMapping("/")
    public String sayHello() {
        //return "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
        return "index";
    }
}
