package com.safeguard.safeguardbackend.rest.dto;

import com.safeguard.safeguardbackend.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveAccountResponse {

    private String id;

    private String userId;

    private Double balance;

    private List<String> paymentsIds;

    public RetrieveAccountResponse(Account account) {
        setId(account.getId());
        setUserId(account.getUserId());
        setBalance(account.getBalance());
        setPaymentsIds(account.getPaymentsIds());
    }
}
