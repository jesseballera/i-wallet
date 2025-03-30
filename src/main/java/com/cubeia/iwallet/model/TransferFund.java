package com.cubeia.iwallet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferFund(
        @NotBlank(message = "Sender account number is required")
        @JsonProperty("senderAccountNumber")
        String fromAccountNumber,
        @NotBlank(message = "Receiver account number is required")
        @JsonProperty("receiverAccountNumber")
        String toAccountNumber,
        @JsonProperty("amount")
        @DecimalMin(value = "10.00", message = "Amount must be at least 10.00")
        @DecimalMax(value = "10000.00", message = "Amount must not exceed 10,000.00")
        @NotNull(message = "Amount is required") BigDecimal amount) { }
