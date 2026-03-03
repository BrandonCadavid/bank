package com.bank.hexagonal.application.ports.out;
import com.bank.hexagonal.domain.model.Account;
import java.util.Optional;

public interface AccountRepositoryPort {
    Account save(Account account);
    Optional<Account> findById(Long id);
}