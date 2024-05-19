package com.safeguard.safeguardbackend.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrievePaymentsResponse {
    private List<RetrievePaymentResponse> payments;

    private long numOfResults;
}
