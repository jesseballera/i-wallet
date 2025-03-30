package com.cubeia.iwallet.controller;

import com.cubeia.iwallet.model.AddCustomer;
import com.cubeia.iwallet.model.ViewCustomer;
import com.cubeia.iwallet.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    protected CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Add a new customer
    @PostMapping("/add-customer")
    public ResponseEntity<Void> addCustomer(@RequestBody @Valid AddCustomer entity) {
        customerService.addCustomer(entity);
        return ResponseEntity.ok().build();
    }

    // View customer information
    @GetMapping("/view-customer/{id}")
    public ResponseEntity<ViewCustomer> viewCustomerInfo(@PathVariable Long id) {
        ViewCustomer customer = customerService.viewCustomerInfo(id);
        return ResponseEntity.ok().body(customer);
    }
    // View all customers
    @GetMapping
    public ResponseEntity<List<ViewCustomer>> viewAllCustomers() {
        List<ViewCustomer> customers = customerService.viewAllCustomers();
        return ResponseEntity.ok().body(customers);
    }
}
