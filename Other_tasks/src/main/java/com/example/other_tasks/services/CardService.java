package com.example.other_tasks.services;

import com.example.other_tasks.models.Card;
import com.example.other_tasks.repositories.CardRepository;
import com.example.other_tasks.utils.CardSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public void addCard(Card card) {
        log.info("Add new card {}", card);
        cardRepository.save(card);
    }

    public Card getCard(long number, short code) {
        log.info("Get card with number-{} and code-{}", number, code);
        return cardRepository.findByNumberAndCode(number, code);
    }

    public void deleteCard(long number, short code) {
        Card card = cardRepository.findByNumberAndCode(number, code);
        if (card != null) {
            log.info("Delete card {}", card);
            cardRepository.delete(card);
        }
    }

    public List<Card> showCards() {
        log.info("Show cards");
        return cardRepository.findAll();
    }

    public boolean existsCard(long number, short code) {
        log.info("Check existing card with number-{} and code-{}", number, code);
        return cardRepository.existsByNumberAndCode(number, code);
    }

    public List<Card> searchCards(String criteria) {
        log.info("Search cards with criteria-{}", criteria);
        return cardRepository.findAll(new CardSpecification(criteria));
    }
}
