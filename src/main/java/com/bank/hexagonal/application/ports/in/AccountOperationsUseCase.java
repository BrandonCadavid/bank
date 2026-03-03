package com.bank.hexagonal.application.ports.in;
import com.bank.hexagonal.domain.model.Account;
import java.math.BigDecimal;

public interface AccountOperationsUseCase {
    Account createAccount(String name, BigDecimal balance);
    Account getAccount(Long id);
    void performTransfer(Long fromId, Long toId, BigDecimal amount);
}