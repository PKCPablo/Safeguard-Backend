package com.safeguard.safeguardbackend.rest.impl;

import com.safeguard.safeguardbackend.model.PaymentHistory;
import com.safeguard.safeguardbackend.rest.PaymentHistoryController;
import com.safeguard.safeguardbackend.rest.dto.CreatePaymentHistoryRequest;
import com.safeguard.safeguardbackend.rest.dto.RetrieveAccountResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentHistoriesResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentHistoryResponse;
import com.safeguard.safeguardbackend.service.PaymentHistoryService;
import com.safeguard.safeguardbackend.service.dto.CreatePaymentHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaymentHistoryControllerImpl implements PaymentHistoryController {

    @Autowired
    PaymentHistoryService paymentHistoryService;

    @Override
    public ResponseEntity<RetrievePaymentHistoryResponse> retrievePaymentHistory(String id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user ID");
        }
        var response = new RetrievePaymentHistoryResponse(paymentHistoryService.retrievePaymentHistory(id));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<RetrievePaymentHistoriesResponse> retrievePaymentHistories() {
        var list = paymentHistoryService.retrievePaymentHistories();
        var response = new RetrievePaymentHistoriesResponse();

        response.setNumOfResults(list.size());
        response.setPaymentHistories(list.stream().map(RetrievePaymentHistoryResponse::new).toList());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> createPaymentHistory(CreatePaymentHistoryRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account on request");
        }
        paymentHistoryService.createPaymentHistory(new CreatePaymentHistoryDTO(request));

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deletePaymentHistory(String id) {
        paymentHistoryService.deletePaymentHistory(id);

        return ResponseEntity.ok(null);
    }
}
