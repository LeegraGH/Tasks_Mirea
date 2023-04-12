package com.example.task_15.services;

import com.example.task_15.models.Card;
import com.example.task_15.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public void addCard(Card card) {
        cardRepository.save(card);
    }

    public Card getCard(long number, short code) {
        return cardRepository.findByNumberAndCode(number, code);
    }

    public void deleteCard(long number, short code) {
        Card card = cardRepository.findByNumberAndCode(number, code);
        if (card != null) cardRepository.delete(card);
    }

    public void updateCard(Card card){
        cardRepository.flush();
    }

    public List<Card> showCards() {
        return cardRepository.findAll();
    }

    public boolean existsCard(long number, short code) {
        return cardRepository.existsByNumberAndCode(number, code);
    }
}
