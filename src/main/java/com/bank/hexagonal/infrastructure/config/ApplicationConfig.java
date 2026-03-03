package com.bank.hexagonal.infrastructure.config;

import com.bank.hexagonal.application.ports.out.AccountRepositoryPort;
import com.bank.hexagonal.application.usecases.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    /**
     * Aquí ocurre la magia: Spring inyecta automáticamente el JpaAccountAdapter
     * porque implementa la interfaz AccountRepositoryPort.
     */
    @Bean
    public AccountService accountService(AccountRepositoryPort repositoryPort) {
        return new AccountService(repositoryPort);
    }
}