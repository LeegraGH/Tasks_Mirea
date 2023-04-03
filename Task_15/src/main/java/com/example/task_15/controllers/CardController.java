package com.example.task_15.controllers;

import com.example.task_14.bank.entity.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/card")
public class CardController {


    private ArrayList<Card> cards = new ArrayList<>();

    @GetMapping("/add")
    public String createCard(@RequestParam(value = "number") long number,
                             @RequestParam(value = "code") short code,
                             Model model) {
        Card card = new Card(number, code);
        cards.add(card);
        System.out.println("Count of cards: " + cards.size() + "\nAdded card: " + card);
        model.addAttribute("type", "add card");
        model.addAttribute("data", card);
        return "card";
    }

    @GetMapping("/delete")
    public String deleteCard(@RequestParam(value = "number") long number,
                             @RequestParam(value = "code") short code,
                             Model model) {
        Card cloneCard = new Card(number, code);
        model.addAttribute("type", "delete card");
        if (cards.removeIf(card -> Objects.equals(card.getCardNumber(), number) && Objects.equals(card.getCode(), code))) {
            System.out.println("Count of cards: " + cards.size() + "\nRemoved card: " + cloneCard);
            model.addAttribute("data", cloneCard);
        } else {
            System.out.println("Count of cards: " + cards.size() + "\nRemoved card: " + "not found");
            model.addAttribute("data", "not found");
        }
        return "card";
    }

    @GetMapping("/show")
    public String showCards(Model model) {
        model.addAttribute("type", "show cards");
        if (cards.isEmpty()) {
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("cards", cards);
        }
        System.out.println("All cards: ");
        int cnt = 0;
        for (Card card : cards) {
            System.out.println(++cnt + ". " + card);
        }
        return "card";
    }
}
