package com.example.Hibernate.controler;


import com.example.Hibernate.entity.Contact;
import com.example.Hibernate.repo.DepartmentRepository;
import com.example.Hibernate.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private DepartmentRepository departmentRep;

    @Autowired
    private StudentRepo repo;

    @GetMapping(value = "/")
    public String displayIndex(Model model) {
        model.addAttribute("dep", new Contact.Department());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("deplist", this.departmentRep.findAll());
        return "student";
    }


    @PostMapping(value = "/")
    public String save(Model model, @Valid Contact.Department department, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something wrong");
            model.addAttribute("list", this.repo.findAll());

        } else {
            this.repo.save(student);
            model.addAttribute("successMsg", "Data save successfully");
            model.addAttribute("successfullly", "something wrong");
            model.addAttribute("list", this.repo.findAll());

        }
        return "student";
    }

    @GetMapping(value = "/stubydep")
    public String showStudentByDepartment(Model model) {
        Contact.Department department = new Contact.Department();
        department.setId(1L);
        model.addAttribute("listbydep", this.repo.findAllByDepartment(department));

        return "studentbydep";
    }


    @GetMapping(value = "/profile")
    public String showStudentById(Model model, @RequestParam(value = "studentid", required = false, defaultValue = "1") Long id) {
        model.addAttribute("student", this.repo.findAll());
        model.addAttribute("student", this.repo.getOne(id));

        return "profilepage";
    }


}
}
