package com.cubeia.iwallet.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public class AddCustomer {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @NotNull(message = "Beneficiaries are required")
    private Set<AddBeneficiary> beneficiaries;
    @NotNull(message = "Accounts are required")
    private Set<AddAccount> accounts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<AddBeneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(Set<AddBeneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Set<AddAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AddAccount> accounts) {
        this.accounts = accounts;
    }
}
