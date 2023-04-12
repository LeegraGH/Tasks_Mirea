package com.example.task_15.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address", columnDefinition = "text")
    private String address;


    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", address = " + address;
    }

}
