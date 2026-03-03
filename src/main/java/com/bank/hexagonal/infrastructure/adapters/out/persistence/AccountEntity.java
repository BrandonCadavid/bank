package com.bank.hexagonal.infrastructure.adapters.out.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String holderName;
    private BigDecimal balance;

    public AccountEntity() {}

    public AccountEntity(Long id, String holderName, BigDecimal balance) {
        this.id = id;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters y Setters explícitos para evitar errores de compilación
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}