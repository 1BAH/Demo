package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float amount;

    private char type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank", nullable = false)
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account", nullable = false)
    private User user;

    public Account() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Float getAmount() {
        return amount;
    }

    public char getType() {
        return type;
    }

    public Account(float amount, char type, Bank bank, User user) {
        this.amount = amount;
        this.type = type;
        this.bank = bank;
        this.user = user;
    }
}
