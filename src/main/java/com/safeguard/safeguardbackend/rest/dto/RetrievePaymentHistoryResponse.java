package com.safeguard.safeguardbackend.rest.dto;

import com.safeguard.safeguardbackend.model.PaymentHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrievePaymentHistoryResponse {
    private String id;

    private String userId;

    private List<String> paymentsId;

    public RetrievePaymentHistoryResponse(PaymentHistory paymentHistory) {
        setId(paymentHistory.getId());
        setUserId(paymentHistory.getUserId());
        setPaymentsId(paymentHistory.getPaymentsId());
    }
}
