package com.safeguard.safeguardbackend.service.dto;

import com.safeguard.safeguardbackend.rest.dto.CreatePaymentHistoryRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentHistoryDTO {
    private String id;

    private String userId;

    private List<String> paymentsId;

    public CreatePaymentHistoryDTO(CreatePaymentHistoryRequest request) {
        setId(request.getId());
        setUserId(request.getUserId());
        setPaymentsId(request.getPaymentsId());
    }
}
