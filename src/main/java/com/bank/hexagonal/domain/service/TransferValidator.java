package com.bank.hexagonal.domain.service;

import com.bank.hexagonal.domain.model.Account;
import java.math.BigDecimal;

/**
 * SERVICIO DE DOMINIO:
 * Se usa cuando una regla de negocio involucra múltiples entidades
 * o no tiene sentido dentro de una clase Account.
 */
public class TransferValidator {
    public static void validate(Account from, BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("10000")) > 0) {
            throw new RuntimeException("Regla de Negocio: Transferencias mayores a 10k requieren aprobación humana");
        }
    }
}