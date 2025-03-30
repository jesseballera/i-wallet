package com.cubeia.iwallet.service;

import com.cubeia.iwallet.model.*;

public interface AccountService {
    ViewAccountBalance getBalance(String accountNumber);
    void transferFunds(TransferFund transferFund);
    ViewTransaction viewAllTransaction(String accountNumber);
    void depositAccount(String accountNumber, ProcessTransaction entity);

}
