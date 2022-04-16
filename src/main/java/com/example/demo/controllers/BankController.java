package com.example.demo.controllers;


import com.example.demo.models.Bank;
import com.example.demo.repos.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {
    @Autowired
    private BankRepo bankRepo;

    @GetMapping("/banks")
    public String accountsPage(Model model) {
        Iterable<Bank> banks = bankRepo.findAll();
        model.addAttribute("banks", banks);
        return "bank";
    }

    @PostMapping("/banks/add")
    public String addPostAccountPage(@RequestParam String name, @RequestParam String percentage, Model model) {
        Bank bank = new Bank(name, Float.parseFloat(percentage));
        bankRepo.save(bank);
        return "redirect:/";
    }

    @GetMapping("banks/add/form")
    public String addGetAccountPage(@RequestParam("name") String name, @RequestParam("percentage") String percentage, Model model) {
        Bank bank = new Bank(name, Float.parseFloat(percentage));
        bankRepo.save(bank);
        return "redirect:/";
    }

    @GetMapping("/banks/add")
    public String addAccountPage(Model model) {
        return "add-bank";
    }


}
