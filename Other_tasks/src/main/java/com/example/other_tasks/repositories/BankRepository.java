package com.example.other_tasks.repositories;

import com.example.other_tasks.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>, JpaSpecificationExecutor<Bank> {
    Bank findByNameAndAddress(String name, String address);
    boolean existsBankByNameAndAddress(String name, String address);

    
}
