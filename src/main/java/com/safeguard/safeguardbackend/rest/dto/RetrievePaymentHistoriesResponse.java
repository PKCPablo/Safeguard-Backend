package com.safeguard.safeguardbackend.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrievePaymentHistoriesResponse {
    private List<RetrievePaymentHistoryResponse> paymentHistories;

    private long numOfResults;
}
