package com.arefin.sunshinefarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHome(){

        return "index";
    }

    @GetMapping(value = "/add-test.jsf")
    public String displayTest(){

        return "test";
    }

}
