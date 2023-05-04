package com.example.other_tasks.modelTest;

import com.example.other_tasks.models.Bank;
import com.example.other_tasks.repositories.BankRepository;
import com.example.other_tasks.services.BankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BankTest {
    @Mock
    private BankRepository bankRepository;
    @Test
    void getBank() {
//        Bank bank = new Bank();
//        bank.setId(52L);
//        bank.setName("Sber");
//        bank.setAddress("Moscow");
//
//        Mockito.when(bankRepository.findById(52L)).thenReturn(Optional.of(bank));

//        BankService bankService = new BankService();
//        bankService.setBankRepository();
//
//        Assertions.assertEquals("Sber",bankService.getBank("Sber","Moscow").getName());
    }
}
