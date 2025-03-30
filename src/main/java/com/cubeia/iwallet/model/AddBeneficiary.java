package com.cubeia.iwallet.model;

import jakarta.validation.constraints.NotBlank;


public class AddBeneficiary{
        @NotBlank(message = "First name is required")
        private String firstName;
        @NotBlank(message = "Last name is required")
        private String lastName;
        @NotBlank(message = "Account number is required")
        private String accountNumber;
        @NotBlank(message = "Bank name is required")
        private String bankName;

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

        public String getAccountNumber() {
                return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
        }

        public String getBankName() {
                return bankName;
        }

        public void setBankName(String bankName) {
                this.bankName = bankName;
        }
}
