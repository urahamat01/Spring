package com.coderbd.simplethymeleaftemplate;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.tomcat.jni.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.swing.BakedArrayList;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class UserControler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "list")
    public String getList(Model model) {
        List<User> list = this.userRepository.findAll();
        model.addAttribute("list", list);

        return "users/list";
    }

    @GetMapping(value = "add")
    public String addView(Model model, @Valid User user) {

        model.addAttribute("user", new User());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String add(Model model, @Valid User user) {

        model.addAttribute("user", new User());
        model.addAttribute("success", "User Saved Successfully");
        return "users/add";
    }




    @GetMapping(value = "/delete/(id)")
    public String delete(@PathVariable long id) {


        return "redirect: /user/list";
    }


}
