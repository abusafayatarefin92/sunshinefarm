package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RollController {
    @Autowired
    RoleRepo roleRepo;

    @GetMapping(value = "create.jsf")
    public String displayRole(Model model){
        model.addAttribute("obj", new Role());
        return "role/create";
    }

    @PostMapping(value = "create.jsf")
    public String saveRole(@Valid Role obj, BindingResult result, Model model){
        if(obj != null) {
            roleRepo.save(obj);
            model.addAttribute("successMsg", "Success");
            model.addAttribute("obj", new Role());
        }
        return "role/create";
    }
}
