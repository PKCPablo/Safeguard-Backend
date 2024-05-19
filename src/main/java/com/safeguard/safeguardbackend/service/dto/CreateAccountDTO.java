package com.safeguard.safeguardbackend.service.dto;

import com.safeguard.safeguardbackend.rest.dto.CreateAccountRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountDTO {
    private String userId;

    private Double balance;

    private List<String> payments;

    public CreateAccountDTO(CreateAccountRequest request) {
        setUserId(request.getUserId());
        setBalance(request.getBalance());
        setPayments(request.getPaymentsIds());
    }
}
