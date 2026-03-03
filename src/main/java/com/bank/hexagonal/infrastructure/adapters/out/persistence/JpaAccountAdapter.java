package com.bank.hexagonal.infrastructure.adapters.out.persistence;

import com.bank.hexagonal.application.ports.out.AccountRepositoryPort;
import com.bank.hexagonal.domain.model.Account;
import com.bank.hexagonal.infrastructure.mappers.AccountMapper;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaAccountAdapter implements AccountRepositoryPort {
    private final SpringDataAccountRepository repository;
    public JpaAccountAdapter(SpringDataAccountRepository repository) { this.repository = repository; }

    @Override
    public Account save(Account account) {
        AccountEntity entity = AccountMapper.toEntity(account);
        return AccountMapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Account> findById(Long id) {
        return repository.findById(id).map(AccountMapper::toDomain);
    }
}