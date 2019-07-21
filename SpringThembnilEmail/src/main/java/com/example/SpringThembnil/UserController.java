package com.example.SpringThembnil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class UserController {

    //Save the uploaded file to this folder
  //  private static String UPLOADED_FOLDER = "D:/spring/Spring-37/springmvcinpurvalidation/src/main/resources/static/images/";
    //private static String UPLOADED_FOLDER = "images/"; //Okay when images folder is at project root
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        this.repo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        return "index";
    }

    @GetMapping("/add")
    public String showForm(User user, Model model) {
model.addAttribute("roleList", this.roleRepo.findAll());
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {

        if (bindingResult.hasErrors()) {
            return "add-page";
        }
        user.setRegiDate(new Date());


        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            user.setFileName("new-" + file.getOriginalFilename());
            user.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            user.setFilePath("images/" + "new-" + file.getOriginalFilename());
            user.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////

            this.repo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("roleList", this.roleRepo.findAll());
            model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "add-page";
    }


    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.repo.getOne(id));
        return "edit-page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult,
                       @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "edit-page";
        }
        this.repo.save(user);
        return "redirect:/";
    }


    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/";
    }


//
//    @PostMapping("/")
//    public String save(@Valid User user, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//        this.repo.save(user);
//
//        return "redirect:/results";
//    }
}
