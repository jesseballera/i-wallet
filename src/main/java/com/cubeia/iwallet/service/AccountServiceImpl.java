package com.cubeia.iwallet.service;

import com.cubeia.iwallet.exceptions.AccountNotFoundException;
import com.cubeia.iwallet.model.*;
import com.cubeia.iwallet.repository.AccountRepository;
import com.cubeia.iwallet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    protected AccountRepository accountRepository;
    protected CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }
    /**
     * @param accountNumber
     * @return
     */
    @Override
    public ViewAccountBalance getBalance(String accountNumber) {
        Account account = checkAccountNumber(accountNumber);
        return ViewAccountBalance.build(account);
    }

    /**
     * @param transferFund
     */
    @Override
    @Transactional
    public void transferFunds(TransferFund transferFund) {
        Account senderAccount = accountRepository.findByAccountNumber(transferFund.fromAccountNumber()).orElseThrow(() -> new AccountNotFoundException("Sender account not found"));
        Account receiverAccount = accountRepository.findByAccountNumber(transferFund.toAccountNumber()).orElseThrow(() -> new AccountNotFoundException("Receiver account not found"));
        if (senderAccount.getBalance().compareTo(transferFund.amount()) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        senderAccount.setBalance(senderAccount.getBalance().subtract(transferFund.amount()));
        receiverAccount.setBalance(receiverAccount.getBalance().add(transferFund.amount()));

        //sender account transaction

        Transaction senderTransaction = new Transaction();
        senderTransaction.setType(Transaction.TransactionType.DEBIT);
        senderTransaction.setTransactionAmount(transferFund.amount());
        senderTransaction.setTransactionDate(LocalDateTime.now());
        senderAccount.getTransactions().add(senderTransaction);

        //receiver account transaction
        Transaction receiverTransaction = new Transaction();
        receiverTransaction.setType(Transaction.TransactionType.CREDIT);
        receiverTransaction.setTransactionAmount(transferFund.amount());
        receiverTransaction.setTransactionDate(LocalDateTime.now());
        receiverAccount.getTransactions().add(receiverTransaction);

        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }

    /**
     * @param accountNumber
     * @return
     */
    @Override
    public ViewTransaction viewAllTransaction(String accountNumber) {
        Account account =  checkAccountNumber(accountNumber);
        ViewTransaction transaction = ViewTransaction.build(account);
        return transaction;
    }

    //check account number if it exists in the database
    private Account checkAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new AccountNotFoundException("Account number not found"));
    }

    /**
     * @param accountNumber
     */
    @Override
    @Transactional
    public void depositAccount(String accountNumber, ProcessTransaction entity) {
        checkAccountNumber(accountNumber);
        Account account = accountRepository.findByAccountNumber(accountNumber).get();
        account.setBalance(account.getBalance().add(entity.amount()));

        Set<Transaction> transactions = new HashSet<>();
//        for (AddAccount txn : account.) {
            Transaction transaction = new Transaction();
            transaction.setTransactionAmount(entity.amount());
            transaction.setType(Transaction.TransactionType.DEPOSIT);
            transaction.setTransactionDate(LocalDateTime.now());
            transactions.add(transaction);
//        }
        account.getTransactions().add(transaction);
        accountRepository.save(account);

    }
}
