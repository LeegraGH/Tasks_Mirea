package com.example.other_tasks.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "banks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address", columnDefinition = "text")
    private String address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Card> cards;


    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", address = " + address;
    }
}
