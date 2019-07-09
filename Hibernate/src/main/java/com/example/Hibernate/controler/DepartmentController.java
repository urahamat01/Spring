package com.example.Hibernate.controler;


import com.example.Hibernate.entity.Contact;
import com.example.Hibernate.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @GetMapping(value = "/")
    public String displayIndex(Model model) {
        model.addAttribute("dep", new Contact.Department());
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }


    @PostMapping(value = "/")
    public String save(Model model, @Valid Contact.Department department, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something wrong");


        } else {
            this.repo.save(department);
            model.addAttribute("successfullly", "something wrong");
            model.addAttribute("list", this.repo.findAll());

        }

        return "index";
    }
}
