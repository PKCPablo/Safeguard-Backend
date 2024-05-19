package com.safeguard.safeguardbackend.rest.dto;

import com.safeguard.safeguardbackend.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrievePaymentResponse {
    private String id;

    private String accountFromId;

    private String accountToId;

    private Double amount;

    public RetrievePaymentResponse(Payment payment) {
        setId(payment.getId());
        setAccountFromId(payment.getAccountFromId());
        setAccountToId(payment.getAccountToId());
        setAmount(payment.getAmount());
    }
}
