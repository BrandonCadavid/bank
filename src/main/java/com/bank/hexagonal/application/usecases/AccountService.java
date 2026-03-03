package com.bank.hexagonal.application.usecases;

import com.bank.hexagonal.application.ports.in.AccountOperationsUseCase;
import com.bank.hexagonal.application.ports.out.AccountRepositoryPort;
import com.bank.hexagonal.domain.model.Account;
import com.bank.hexagonal.domain.service.TransferValidator;
import java.math.BigDecimal;

public class AccountService implements AccountOperationsUseCase {
    private final AccountRepositoryPort repository;

    public AccountService(AccountRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Account createAccount(String name, BigDecimal balance) {
        // Lógica de orquestación para crear
        Account newAccount = new Account(null, name, balance);
        return repository.save(newAccount);
    }

    @Override
    public Account getAccount(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    @Override
    public void performTransfer(Long fromId, Long toId, BigDecimal amount) {
        Account origin = getAccount(fromId);
        Account target = getAccount(toId);

        // Uso del Domain Service
        TransferValidator.validate(origin, amount);

        // Uso de lógica de entidad
        repository.save(origin.withdraw(amount));
        repository.save(target.deposit(amount));
    }
}
