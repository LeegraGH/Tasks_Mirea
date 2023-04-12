package com.example.other_tasks.controllers;


import com.example.other_tasks.models.Bank;
import com.example.other_tasks.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/bank")
@Controller
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("/add")
    public String createBank(@RequestParam(value = "name") String name,
                             @RequestParam(value = "address") String address,
                             Model model) {
        Bank bank = new Bank(name, address);
        if (!bankService.existsBank(name, address)) bankService.addBank(bank);
        System.out.println("Added bank: " + bank);
        model.addAttribute("type", "add bank");
        model.addAttribute("data", bankService.getBank(name, address));
        return "bank";
    }

    @GetMapping("/delete")
    public String deleteBank(@RequestParam(value = "name") String name,
                             @RequestParam(value = "address") String address,
                             Model model) {
        model.addAttribute("type", "delete bank");
        Bank bank = bankService.getBank(name, address);
        bankService.deleteBank(name, address);
        System.out.println("Removed bank: " + bank);
        model.addAttribute("data", bank);
        return "bank";
    }

    @GetMapping("/show")
    public String showBanks(Model model) {
        model.addAttribute("type", "show banks");
        List<Bank> banks = bankService.showBanks();
        if (banks.isEmpty()) {
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("banks", banks);
        }
        System.out.println("All banks: ");
        int cnt = 0;
        for (Bank bank : banks) {
            System.out.println(++cnt + ". " + bank);
        }
        return "bank";
    }

    @GetMapping("/search")
    public String searchBanks(@RequestParam(value = "criteria") String criteria,
                              Model model) {
        model.addAttribute("type", "search banks");
        List<Bank> banks = bankService.searchBanks(criteria);
        if (banks.isEmpty()) {
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("banks", banks);
        }
        System.out.println("All search banks: ");
        int cnt = 0;
        for (Bank bank : banks) {
            System.out.println(++cnt + ". " + bank);
        }
        return "bank";
    }
}
