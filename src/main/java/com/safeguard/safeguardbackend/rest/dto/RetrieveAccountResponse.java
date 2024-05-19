package com.safeguard.safeguardbackend.rest.dto;

import com.safeguard.safeguardbackend.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveAccountResponse {

    private String id;

    private String userId;

    private Double balance;

    public RetrieveAccountResponse(Account account) {
        setId(account.getId());
        setUserId(account.getUserId());
        setBalance(account.getBalance());
    }
}
