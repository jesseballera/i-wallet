package com.cubeia.iwallet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ViewAccountBalance {
    private String accountNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal balance;
    private Account.AccountType accountType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime timestamp;

    public ViewAccountBalance() {
    }

    public static ViewAccountBalance build(Account account) {
        ViewAccountBalance viewAccountBalance = new ViewAccountBalance();
        viewAccountBalance.setAccountNumber(account.getAccountNumber());
        viewAccountBalance.setBalance(account.getBalance());
        viewAccountBalance.setTimestamp(LocalDateTime.now());
        viewAccountBalance.setAccountType(account.getType());
        return viewAccountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
    }
}
