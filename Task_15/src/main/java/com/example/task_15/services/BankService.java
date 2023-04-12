package com.example.task_15.services;

import com.example.task_15.models.Bank;
import com.example.task_15.repositories.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    public Bank getBank(String name, String address) {
        return bankRepository.findByNameAndAddress(name, address);
    }

    public boolean existsBank(String name, String address) {
        return bankRepository.existsBankByNameAndAddress(name, address);
    }

    public void deleteBank(String name, String address) {
        Bank bank = bankRepository.findByNameAndAddress(name, address);
        if (bank != null) bankRepository.delete(bank);
    }

    public List<Bank> showBanks() {
        return bankRepository.findAll();
    }

}
