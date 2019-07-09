package com.example.springThyemSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private StudentRepo repo;

    @GetMapping(value = "/home")
    public String displayHome(){
        return "home";
    }
    @GetMapping(value = "/hello")
    public String displayHello(){
        return "hello";
    }
    @GetMapping(value = "/login")
    public String displaylogin(){
        return "login";
    }

    @GetMapping(value = "/")
    public String displayIndex(){
        return "index";
    }



}
