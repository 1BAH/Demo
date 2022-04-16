package com.example.demo.controllers;


import com.example.demo.models.Account;
import com.example.demo.models.Bank;
import com.example.demo.models.User;
import com.example.demo.repos.AccountRepo;
import com.example.demo.repos.BankRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BankRepo bankRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/accounts")
    public String accountsPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepo.findByName(authentication.getName());
        Iterable<Account> accounts = currentUser.getAccounts();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @GetMapping("/accounts/add/form")
    public String addPostAccountPage(@RequestParam String type, @RequestParam String amount, @RequestParam String bankId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepo.findByName(authentication.getName());
        Account account = new Account(Float.parseFloat(amount), type.charAt(0), bankRepo.findById(Long.parseLong(bankId)).get(), currentUser);
        accountRepo.save(account);
        return "redirect:/accounts";
    }

    @GetMapping("/accounts/add")
    public String addAccountPage(Model model) {
        Iterable<Bank> banks = bankRepo.findAll();
        model.addAttribute("banks", banks);
        return "add";
    }
}
