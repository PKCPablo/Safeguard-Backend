package com.safeguard.safeguardbackend.rest;

import com.safeguard.safeguardbackend.model.Payment;
import com.safeguard.safeguardbackend.rest.dto.CreatePaymentRequest;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrievePaymentsResponse;
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
public interface PaymentController {

    @RequestMapping(path = "/payment/{id}", method = RequestMethod.GET)
    ResponseEntity<RetrievePaymentResponse> retrievePayment(@PathVariable("id") String id);

    @RequestMapping(path = "/payment", method = RequestMethod.GET)
    ResponseEntity<RetrievePaymentsResponse> retrievePayments();

    @RequestMapping(path = "/payment", method = RequestMethod.POST)
    ResponseEntity<Void> createPayment(@RequestBody CreatePaymentRequest request);

    @RequestMapping(path = "/payment/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePayment(@PathVariable("id") String id);
}
