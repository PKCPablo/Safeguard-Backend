package com.safeguard.safeguardbackend.rest;

import com.safeguard.safeguardbackend.model.PaymentHistory;
import com.safeguard.safeguardbackend.rest.dto.CreatePaymentHistoryRequest;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentHistoriesResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentHistoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
public interface PaymentHistoryController {

    @RequestMapping(path = "/paymentHistory/{id}", method = RequestMethod.GET)
    ResponseEntity<RetrievePaymentHistoryResponse> retrievePaymentHistory(@PathVariable("id") String id);

    @RequestMapping(path = "/paymentHistory", method = RequestMethod.GET)
    ResponseEntity<RetrievePaymentHistoriesResponse> retrievePaymentHistories();

    @RequestMapping(path = "/paymentHistory", method = RequestMethod.POST)
    ResponseEntity<Void> createPaymentHistory(@RequestBody CreatePaymentHistoryRequest request);

    @RequestMapping(path = "/paymentHistory/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePaymentHistory(@PathVariable("id") String id);
}
