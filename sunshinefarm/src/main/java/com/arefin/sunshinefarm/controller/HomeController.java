package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private UserRepo userRepo;

    @GetMapping(value = "/sec")
    public String displayHome(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        User user = userRepo.findByUserName(auth.getName());
        model.addAttribute("name", user.getName());
        return "secure/secure";
    }

    @GetMapping(value = "/adm")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping(value = "/customers")
    public String customers(){
        return "customers/customers";
    }
}
