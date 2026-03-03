package com.bank.hexagonal.domain.model;

import com.bank.hexagonal.domain.exception.BusinessException;
import java.math.BigDecimal;

public record Account(Long id, String holderName, BigDecimal balance) {

    public Account {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("El saldo inicial no puede ser negativo");
        }
    }

    public Account withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new BusinessException("Monto inválido");
        if (this.balance.compareTo(amount) < 0) throw new BusinessException("Saldo insuficiente");
        return new Account(id, holderName, balance.subtract(amount));
    }

    public Account deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new BusinessException("Monto inválido");
        return new Account(id, holderName, balance.add(amount));
    }
}
