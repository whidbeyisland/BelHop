package com.example.easynotes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

    @GetMapping("/login")
	public String login() {
        //return "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
        return "login";
    }

    @GetMapping("/create-account")
	public String createAccount() {
        //return "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
        return "create-account";
    }

    @GetMapping("/index-unchanged")
	public String indexUnchanged() {
        //return "Hello and Welcome to the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
        return "index-unchanged";
    }
}
