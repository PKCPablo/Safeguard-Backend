package com.safeguard.safeguardbackend.service;

import com.safeguard.safeguardbackend.model.Payment;
import com.safeguard.safeguardbackend.service.dto.CreatePaymentDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentService {
    @Transactional(readOnly = true)
    Payment retrievePayment(String id);

    @Transactional(readOnly = true)
    List<Payment> retrievePayments();

    @Transactional(readOnly = false)
    void createPayment(CreatePaymentDTO dto);

    @Transactional(readOnly = false)
    void deletePayment(String id);
}
