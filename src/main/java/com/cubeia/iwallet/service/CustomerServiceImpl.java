package com.cubeia.iwallet.service;

import com.cubeia.iwallet.exceptions.CustomerNotFoundException;
import com.cubeia.iwallet.model.*;
import com.cubeia.iwallet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    protected CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * @param entity
     */
    @Override
    @Transactional
    public void addCustomer(AddCustomer entity) {
        Customer customer = new Customer();
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setAddress(entity.getAddress());
        customer.setPhoneNumber(entity.getPhoneNumber());

        Set<Beneficiary> recipients = new HashSet<>();
        for (AddBeneficiary beneficiary : entity.getBeneficiaries()) {
            Beneficiary newBeneficiary = new Beneficiary();
            newBeneficiary.setFirstName(beneficiary.getFirstName());
            newBeneficiary.setLastName(beneficiary.getLastName());
            newBeneficiary.setAccountNumber(beneficiary.getAccountNumber());
            newBeneficiary.setBankName(beneficiary.getBankName());
            recipients.add(newBeneficiary);
        }
        customer.setBeneficiaries(recipients);

        Set<Account> accounts = new HashSet<>();
        for (AddAccount account : entity.getAccounts()) {
            Account newAccount = new Account();
            newAccount.setAccountNumber(account.accountNumber());
            newAccount.setType(account.type());
            newAccount.setBalance(account.balance());
            newAccount.setCustomer(customer);
            accounts.add(newAccount);

            Set<Transaction> transactions = new HashSet<>();
            for (AddAccount txn : entity.getAccounts()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionAmount(txn.balance());
                transaction.setType(Transaction.TransactionType.DEPOSIT);
                transaction.setTransactionDate(LocalDateTime.now());
                transaction.setAccount(accounts);
                transactions.add(transaction);
            }
            newAccount.setTransactions(transactions);
        }

        customer.setAccounts(accounts);
        customerRepository.save(customer);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ViewCustomer viewCustomerInfo(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return ViewCustomer.of(customer);
    }

    /**
     * @return
     */
    @Override
    public List<ViewCustomer> viewAllCustomers() {
        return customerRepository.findAll().stream().map(ViewCustomer::of).collect(Collectors.toList());
    }
}
