package com.example.task_14.controllers;

import com.example.task_14.entity.Bank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Objects;

@RequestMapping("/bank")
@Controller
public class BankController {

    private ArrayList<Bank> banks = new ArrayList<>();

    @GetMapping("/add")
    public String createBank(@RequestParam(value = "name") String name,
                             @RequestParam(value = "address") String address,
                             Model model) {
        Bank bank = new Bank(name, address);
        banks.add(bank);
        System.out.println("Count of banks: " + banks.size() + "\nAdded bank: " + bank);
        model.addAttribute("type", "add bank");
        model.addAttribute("data", bank);
        return "bank";
    }

    @GetMapping("/delete")
    public String deleteBank(@RequestParam(value = "name") String name,
                             @RequestParam(value = "address") String address,
                             Model model) {
        Bank cloneBank = new Bank(name, address);
        model.addAttribute("type", "delete bank");
        if (banks.removeIf(bank -> Objects.equals(bank.getName(), name) && Objects.equals(bank.getAddress(), address))) {
            System.out.println("Count of banks: " + banks.size() + "\nRemoved bank: " + cloneBank);
            model.addAttribute("data", cloneBank);
        } else {
            System.out.println("Count of banks: " + banks.size() + "\nRemoved bank: " + "not found");
            model.addAttribute("data", "not found");
        }
        return "bank";
    }

    @GetMapping("/show")
    public String showBanks(Model model) {
        model.addAttribute("type", "show banks");
        if (banks.isEmpty()){
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("banks", banks);
        }
        System.out.println("All banks: ");
        int cnt=0;
        for (Bank bank: banks) {
            System.out.println(++cnt+". "+bank);
        }
        return "bank";
    }
}
