package com.example.springActuator1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/")
    public  String index(){
        return "Hellow  Spring Rest API";
    }
    @GetMapping(value = "/test")
    public  String indexTest(){
        return "hi Hellow  Spring Rest API";
    }
}
