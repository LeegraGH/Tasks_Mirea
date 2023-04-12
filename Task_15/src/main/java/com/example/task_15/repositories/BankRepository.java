package com.example.task_15.repositories;

import com.example.task_15.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByNameAndAddress(String name, String address);
    boolean existsBankByNameAndAddress(String name, String address);
}
