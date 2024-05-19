package com.safeguard.safeguardbackend.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveAccountsResponse {
    private List<RetrieveAccountResponse> accounts;

    private long numOfResults;
}
