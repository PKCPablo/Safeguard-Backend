package com.safeguard.safeguardbackend.service.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.safeguard.safeguardbackend.rest.dto.CreatePaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentDTO {

    private String id;

    private String accountFromId;

    private String accountToId;

    private Double amount;

    public CreatePaymentDTO(CreatePaymentRequest request) {
        setId(request.getId());
        setAccountFromId(request.getAccountFromId());
        setAccountToId(request.getAccountToId());
        setAmount(request.getAmount());
    }
}
