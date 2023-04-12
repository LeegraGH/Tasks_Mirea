package com.example.task_15.models;


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

    public Card(long number, short code) {
        this.number = number;
        this.code = code;
    }

    @Override
    public String toString() {
        return "number = " + number + ", code = " + code;
    }
}
