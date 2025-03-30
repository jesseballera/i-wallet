package com.cubeia.iwallet.model;

import java.math.BigDecimal;

public record AddAccount(
        String accountNumber,
        Account.AccountType type,
        BigDecimal balance) { }
