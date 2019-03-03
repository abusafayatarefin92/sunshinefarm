package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RollController {
    @Autowired
    RoleRepo roleRepo;

    @GetMapping(value = "add")
    public String addRoleView(Role role){
        return "role/add";
    }

    @PostMapping(value = "add")
    public String addRole(@Valid Role role, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "role/add";
        }else {
            if(role != null){
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if(role1 != null){
                    model.addAttribute("exist", "Role already exist");
                }else {
                    role.setRoleName(role.getRoleName().toUpperCase());
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successrole", "Role Successfully added");
                }
            }
        }

        return "role/add";
    }

    @GetMapping(value = "edit/{id}")
    public String editRoleView(Role role, @PathVariable("id") Long id, Model model){
        model.addAttribute("roleforone", this.roleRepo.getOne(id));
        return "role/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String editRole(@Valid Role role, BindingResult bindingResult, @PathVariable("id") Integer id, Model model){
        if(bindingResult.hasErrors()){
            return "role/edit";
        }else {
            if(role != null){
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if(role1 != null){
                    model.addAttribute("exist", "Role already exist");
                }else {
                    role.setRoleName(role.getRoleName().toUpperCase());
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successrole", "Role Successfully edited");
                }
            }
        }

        return "role/role-list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        if (id != null){
            this.roleRepo.deleteById(id);
        }

        return "role/role-list";
    }

    @GetMapping(value = "role-list")
    public String roleList(Model model){
        model.addAttribute("list", this.roleRepo.findAll());
        return "role/role-list";
    }
}
