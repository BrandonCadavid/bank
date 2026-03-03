package com.bank.hexagonal.infrastructure.adapters.in.rest;

import com.bank.hexagonal.application.ports.in.AccountOperationsUseCase;
import com.bank.hexagonal.domain.model.Account;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountOperationsUseCase useCase;

    public AccountController(AccountOperationsUseCase useCase) { this.useCase = useCase; }

    @PostMapping
    public Account create(@RequestParam String name, @RequestParam BigDecimal balance) {
        return useCase.createAccount(name, balance);
    }

    @PostMapping("/{fromId}/transfer/{toId}")
    public void transfer(@PathVariable Long fromId, @PathVariable Long toId, @RequestParam BigDecimal amount) {
        useCase.performTransfer(fromId, toId, amount);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) { return useCase.getAccount(id); }
}