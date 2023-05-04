package com.example.other_tasks.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "number")
    private long number;
    @Column(name = "code")
    private short code;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Card(long number, short code) {
        this.number = number;
        this.code = code;
    }

    @Override
    public String toString() {
        if (bank!=null) return "number = " + number + ", code = " + code + ", bank_id = " + bank.getId();
        else return "number = " + number + ", code = " + code + ", bank_id = null";
    }
}
