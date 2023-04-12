package com.example.other_tasks.controllers;

import com.example.other_tasks.models.Card;
import com.example.other_tasks.services.BankService;
import com.example.other_tasks.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final BankService bankService;

    @GetMapping("/add")
    public String createCard(@RequestParam(value = "number") long number,
                             @RequestParam(value = "code") short code,
                             Model model) {
        Card card = new Card(number, code);
        char firstDigitCard = String.valueOf(card.getNumber()).charAt(0);
        if (firstDigitCard == '1') {
            if (bankService.existsBank("Sber", "Moscow")) card.setBank(bankService.getBank("Sber", "Moscow"));
            else card.setBank(null);
        } else if (firstDigitCard == '2') {
            if (bankService.existsBank("VTB", "Moscow")) card.setBank(bankService.getBank("VTB", "Moscow"));
            else card.setBank(null);
        } else if (firstDigitCard == '3') {
            if (bankService.existsBank("Tinkoff", "Moscow")) card.setBank(bankService.getBank("Tinkoff", "Moscow"));
            else card.setBank(null);
        }
        if (!cardService.existsCard(number, code)) cardService.addCard(card);
        System.out.println("Added card: " + card);
        model.addAttribute("type", "add card");
        model.addAttribute("data", cardService.getCard(number, code));
        return "card";
    }

    @GetMapping("/delete")
    public String deleteCard(@RequestParam(value = "number") long number,
                             @RequestParam(value = "code") short code,
                             Model model) {
        model.addAttribute("type", "delete card");
        Card card = cardService.getCard(number, code);
        cardService.deleteCard(number, code);
        System.out.println("Removed card: " + card);
        model.addAttribute("data", card);
        return "card";
    }

    @GetMapping("/show")
    public String showCards(Model model) {
        model.addAttribute("type", "show cards");
        List<Card> cards = cardService.showCards();
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

    @GetMapping("/search")
    public String searchCards(@RequestParam(value = "criteria") String criteria, Model model) {
        model.addAttribute("type", "search cards");
        List<Card> cards = cardService.searchCards(criteria);
        if (cards.isEmpty()) {
            model.addAttribute("data", "empty");
        } else {
            model.addAttribute("cards", cards);
        }
        System.out.println("All search cards: ");
        int cnt = 0;
        for (Card card : cards) {
            System.out.println(++cnt + ". " + card);
        }
        return "card";
    }
}
