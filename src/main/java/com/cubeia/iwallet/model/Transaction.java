package com.cubeia.iwallet.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;
    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @ManyToMany(mappedBy = "transactions")
    private Set<Account> accounts;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccount(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        DEBIT,
        CREDIT
    }
}


