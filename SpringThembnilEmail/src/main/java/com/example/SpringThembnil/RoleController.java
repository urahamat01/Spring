package com.example.SpringThembnil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/add-role")
    public String addRoleView(Role role){
        return "role/add";

    }

    @PostMapping(value = "/add-role")
    public String addRole(@Valid Role role, BindingResult result, Model model){
        if(result.hasErrors()){
            return "role/add";
        }else{
            if(role != null){
                Role role1=this.repo.findByRoleName(role.getRoleName());
                if(role1 != null ){
                    model.addAttribute("existMsg","RoleName is already exist");
                }else{
                    this.repo.save(role);
                    model.addAttribute("role",new Role());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "role/add";
    }

    @GetMapping(value = "/role-list")
    public String roleList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "role/list";
    }

    @GetMapping(value = "/role-edit/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model){
        model.addAttribute("role", this.repo.getOne(id));
        return "role/edit";

    }

    @PostMapping(value = "/edit-role/{id}")
    public String editRole(@Valid Role role, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            return "role/edit";
        }else{
            if(role != null){
                Role role1=this.repo.findByRoleName(role.getRoleName());
                if(role1 != null ){
                    model.addAttribute("existMsg","RoleName is already exist");
                    return "role/edit";
                }else{
                    this.repo.save(role);
                    model.addAttribute("role",new Role());
                    model.addAttribute("successMsg","Alread Success");
                }           }
        }
        return "redirect:/role-list";
    }

  @RequestMapping(value = "/role-del/{id}",method = RequestMethod.GET)
    public String delRole(@PathVariable("id") Long id){
  this.repo.deleteById(id);
      return "redirect:/role-list";

    }
}
