package com.example.SpringThembnil;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlerControler {
@GetMapping(value = "/")
public String home(Model model){

return "home";

    }
    @GetMapping(value = "/About.bd")
    public String aboutDisplay(Model model){

        return "About";

    }
    @GetMapping(value = "/contact.php")
    public String contactDisplay(Model model){

        return "contact";

    }




}


