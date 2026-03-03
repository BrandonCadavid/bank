package com.bank.hexagonal.infrastructure.mappers;
import com.bank.hexagonal.domain.model.Account;
import com.bank.hexagonal.infrastructure.adapters.out.persistence.AccountEntity;

public class AccountMapper {
    public static Account toDomain(AccountEntity entity) {
        return new Account(entity.getId(), entity.getHolderName(), entity.getBalance());
    }
    public static AccountEntity toEntity(Account domain) {
        return new AccountEntity(domain.id(), domain.holderName(), domain.balance());
    }
}