package com.safeguard.safeguardbackend.rest.impl;

import com.safeguard.safeguardbackend.model.Payment;
import com.safeguard.safeguardbackend.rest.PaymentController;
import com.safeguard.safeguardbackend.rest.dto.CreatePaymentRequest;
import com.safeguard.safeguardbackend.rest.dto.RetrieveAccountResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentsResponse;
import com.safeguard.safeguardbackend.service.PaymentService;
import com.safeguard.safeguardbackend.service.dto.CreatePaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    PaymentService paymentService;

    @Override
    public ResponseEntity<RetrievePaymentResponse> retrievePayment(String id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user ID");
        }
        var response = new RetrievePaymentResponse(paymentService.retrievePayment(id));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<RetrievePaymentsResponse > retrievePayments() {
        var list = paymentService.retrievePayments();
        var response = new RetrievePaymentsResponse();

        response.setNumOfResults(list.size());
        response.setPayments(list.stream().map(RetrievePaymentResponse::new).toList());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> createPayment(CreatePaymentRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account on request");
        }

        paymentService.createPayment(new CreatePaymentDTO(request));
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deletePayment(String id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok(null);
    }
}
