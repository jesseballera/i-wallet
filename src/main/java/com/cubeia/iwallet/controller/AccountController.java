package com.cubeia.iwallet.controller;

import com.cubeia.iwallet.model.*;
import com.cubeia.iwallet.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //get the account balance
    @GetMapping("/balance/{accountNumber}")
    public ViewAccountBalance getBalance(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getBalance(accountNumber);
    }

    @PostMapping("/transfer")
    public void transferFunds(@RequestBody @Valid TransferFund transferFund) {
        accountService.transferFunds(transferFund);
    }

    @GetMapping("/transactions/{accountNumber}")
    public ViewTransaction viewAllTransaction(@PathVariable("accountNumber") String accountNumber) {
        return accountService.viewAllTransaction(accountNumber);
    }

    @PostMapping("/deposit/{accountNumber}")
    public ResponseEntity<Void> depositAccount(@PathVariable("accountNumber") String accountNumber, @Valid @RequestBody ProcessTransaction entity) {
        accountService.depositAccount(accountNumber, entity);
        return ResponseEntity.ok().build();
    }
}
