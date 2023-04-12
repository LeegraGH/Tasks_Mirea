package com.example.task_15.repositories;

import com.example.task_15.models.Bank;
import com.example.task_15.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByNumberAndCode(long number, short code);

    boolean existsByNumberAndCode(long number, short code);
}
