package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.RoleRepo;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @GetMapping(value = "create.jsf")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new User());
        modelAndView.addObject("rolelist", roleRepo.findAll());
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @PostMapping(value = "create.jsf")
    public ModelAndView save(@Valid User obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (obj != null) {
            userRepo.save(obj);
            modelAndView.addObject("successMsg", "Save Success");
            modelAndView.addObject("obj", new User());
            modelAndView.addObject("rolelist", roleRepo.findAll());
            modelAndView.setViewName("user/create");
        }
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @GetMapping(value = "list.jsf")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", userRepo.findAll());
        modelAndView.setViewName("user/list");
        return modelAndView;
    }
}
