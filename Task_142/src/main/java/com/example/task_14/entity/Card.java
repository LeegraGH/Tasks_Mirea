package com.example.task_14.entity;


public class Card {
    private long cardNumber;
    private short code;

    public Card(long cardNumber, short code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public short getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "cardNumber = " + cardNumber + ", code = " + code;
    }
}
