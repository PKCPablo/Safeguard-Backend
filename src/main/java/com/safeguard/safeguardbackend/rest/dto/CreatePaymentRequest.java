package com.safeguard.safeguardbackend.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
    private String id;

    private String accountFromId;

    private String accountToId;

    private Double amount;
}
