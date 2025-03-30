package com.cubeia.iwallet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ViewTransaction {

    private Long transactionId;
    private String accountNumber;
    private Account.AccountType accountType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal runningBalance;
    private Set<AccountTransactions> transactions;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(BigDecimal runningBalance) {
        this.runningBalance = runningBalance;
    }

    public Set<AccountTransactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<AccountTransactions> transactions) {
        this.transactions = transactions;
    }

    public static class AccountTransactions {
        Transaction.TransactionType type;
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        BigDecimal amount;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
        @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
        LocalDateTime timestamp;

        public Transaction.TransactionType getType() {
            return type;
        }

        public void setType(Transaction.TransactionType type) {
            this.type = type;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

    }

    public static ViewTransaction build(Account account) {
        ViewTransaction viewTransaction = new ViewTransaction();
        viewTransaction.setTransactionId(account.getId());
        viewTransaction.setAccountNumber(account.getAccountNumber());
        viewTransaction.setAccountType(account.getType());
        viewTransaction.setRunningBalance(account.getBalance());

        Set<AccountTransactions> transactions = new HashSet<>();
        for (Transaction transaction : account.getTransactions()) {
            AccountTransactions accountTransactions = new AccountTransactions();
            accountTransactions.setType(transaction.getType());
            accountTransactions.setAmount(transaction.getTransactionAmount());
            accountTransactions.setTimestamp(transaction.getTransactionDate());
            transactions.add(accountTransactions);
        }
        viewTransaction.setTransactions(transactions);
        return viewTransaction;
    }
}
