package com.cubeia.iwallet.model;

import java.util.Set;
import java.util.stream.Collectors;

public record ViewCustomer(
        Long id,
        String firstName,
        String lastName,
        String address,
        String phoneNumber,
        Set<ViewBeneficiary> beneficiaries) {

    public static ViewCustomer of(Customer customer) {
        return new ViewCustomer(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getBeneficiaries().stream().map(ViewBeneficiary::of).collect(Collectors.toSet()));
    }
}
