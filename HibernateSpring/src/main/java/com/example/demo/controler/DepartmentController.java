package com.example.demo.controler;


import com.example.demo.entity.Department;
import com.example.demo.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Entity;
import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepo repo;

    @GetMapping(value = "/")
    public String displayIndex(Model model){
        model.addAttribute("department", new Department());
        model.addAttribute("list", this.repo.findAll());

        return "index";
    }

    @PostMapping(value = "/")
    public String save(Model model, @Valid Department department, BindingResult result){
     if (result.hasErrors()){
         model.addAttribute("errMsg", "Sometshing wrong");
     }else {
         this.repo.save(department);
         model.addAttribute("successMsg", "Data save successfully");
         model.addAttribute("list", this.repo.findAll());
     }
        return "index";
    }


}
