package com.example.SpringThembnil;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
    @GetMapping(value = "/")
    public String DisplayIndex(){
        return "index";
    }
}
