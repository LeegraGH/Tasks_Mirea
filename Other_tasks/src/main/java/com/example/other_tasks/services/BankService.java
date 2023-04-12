package com.example.other_tasks.services;

import com.example.other_tasks.models.Bank;
import com.example.other_tasks.repositories.BankRepository;
import com.example.other_tasks.utils.BankSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public void addBank(Bank bank) {
        log.info("Add new bank {}", bank);
        bankRepository.save(bank);
    }

    public Bank getBank(String name, String address) {
        log.info("Get bank with name-{} and address-{}", name, address);
        return bankRepository.findByNameAndAddress(name, address);
    }

    public boolean existsBank(String name, String address) {
        log.info("Check existing bank with name-{} and address-{}", name, address);
        return bankRepository.existsBankByNameAndAddress(name, address);
    }

    public void deleteBank(String name, String address) {
        Bank bank = bankRepository.findByNameAndAddress(name, address);
        if (bank != null) {
            log.info("Delete bank {}", bank);
            bankRepository.delete(bank);
        }
    }

    public List<Bank> showBanks() {
        log.info("Show banks");
        return bankRepository.findAll();
    }

    public List<Bank> searchBanks(String criteria) {
        log.info("Search banks with criteria-{}", criteria);
        return bankRepository.findAll(new BankSpecification(criteria));
    }

}
