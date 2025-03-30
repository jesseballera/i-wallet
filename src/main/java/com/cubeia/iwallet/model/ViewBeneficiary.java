package com.cubeia.iwallet.model;

import jakarta.persistence.*;

import java.io.Serializable;


public record ViewBeneficiary(
        Long id,
        String firstName,
        String lastName,
        String accountNumber,
        String bankName)  {
    public static ViewBeneficiary of(Beneficiary beneficiary) {
        return new ViewBeneficiary(
                beneficiary.getId(),
                beneficiary.getFirstName(),
                beneficiary.getLastName(),
                beneficiary.getAccountNumber(),
                beneficiary.getBankName());
    }
}
