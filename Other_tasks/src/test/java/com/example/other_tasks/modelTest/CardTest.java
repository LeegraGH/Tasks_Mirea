package com.example.other_tasks.modelTest;

import com.example.other_tasks.models.Card;
import com.example.other_tasks.repositories.BankRepository;
import com.example.other_tasks.repositories.CardRepository;
import com.example.other_tasks.services.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CardTest {
    @Mock
    private CardRepository cardRepository;
    @Test
    void getCard() {
        Card card = new Card();
        card.setId(52L);
        card.setNumber(1654362342);
        card.setCode((short) 6755);

        Mockito.when(cardRepository.findById(52L)).thenReturn(Optional.of(card));

//        CardService cardService = new CardService();
//        cardService.setCardRepository(cardRepository);
//
//        Assertions.assertEquals(1654362342,cardService.getCard(1654362342,(short) 6755).getNumber());
    }
}
