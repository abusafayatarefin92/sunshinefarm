package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.entity.Expenses;
import com.arefin.sunshinefarm.repo.DesignationRepo;
import com.arefin.sunshinefarm.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/expenses/")
public class ExpenseController {
    @Autowired
    ExpenseRepo expenseRepo;

    @GetMapping(value = "create.jsf")
    public String displayExpenses(Model model){
        model.addAttribute("obj", new Expenses());
        return "expenses/create";
    }

    @PostMapping(value = "create.jsf")
    public String saveExpenses(@Valid Expenses obj, BindingResult result, Model model){
        if(obj != null) {
            expenseRepo.save(obj);
            model.addAttribute("successMsg", "Success");
            model.addAttribute("obj", new Expenses());
        }
        return "expenses/create";
    }
}
