package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String DisplayLayout(){
        return "layout";
    }
    @GetMapping(value = "/about")
    public String DisplayAbout(){
        return "about";
    }
}
