package com.cubeia.iwallet.model;

import java.math.BigDecimal;

public record ProcessTransaction(
        String accountNumber,
        Transaction.TransactionType transactionType,
        BigDecimal amount) { }

