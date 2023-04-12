package com.example.other_tasks.repositories;

import com.example.other_tasks.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>, JpaSpecificationExecutor<Card> {
    Card findByNumberAndCode(long number, short code);

    boolean existsByNumberAndCode(long number, short code);
}
