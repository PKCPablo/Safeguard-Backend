package com.safeguard.safeguardbackend.service;

import com.safeguard.safeguardbackend.model.PaymentHistory;
import com.safeguard.safeguardbackend.service.dto.CreatePaymentHistoryDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentHistoryService {
    @Transactional(readOnly = true)
    PaymentHistory retrievePaymentHistory(String id);

    @Transactional(readOnly = true)
    List<PaymentHistory> retrievePaymentHistories();

    @Transactional(readOnly = false)
    void createPaymentHistory(CreatePaymentHistoryDTO dto);

    @Transactional(readOnly = false)
    void deletePaymentHistory(String id);
}
