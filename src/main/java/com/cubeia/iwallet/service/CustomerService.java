package com.cubeia.iwallet.service;

import com.cubeia.iwallet.model.AddCustomer;
import com.cubeia.iwallet.model.Customer;
import com.cubeia.iwallet.model.ViewCustomer;

import java.util.List;

public interface CustomerService {

    void addCustomer(AddCustomer entity);
    ViewCustomer viewCustomerInfo(Long id);
    List<ViewCustomer> viewAllCustomers();
}
