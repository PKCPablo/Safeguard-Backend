package com.safeguard.safeguardbackend.service.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.safeguard.safeguardbackend.model.Payment;
import com.safeguard.safeguardbackend.service.PaymentService;
import com.safeguard.safeguardbackend.service.dto.CreatePaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Override
    public Payment retrievePayment(String id) {
        return dynamoDBMapper.load(Payment.class, id);
    }

    @Override
    public List<Payment> retrievePayments() {
        return dynamoDBMapper.scan(Payment.class, new DynamoDBScanExpression());
    }

    @Override
    public void createPayment(CreatePaymentDTO dto) {
        Payment payment = new Payment();

        payment.setId(dto.getId());
        payment.setAccountFromId(dto.getAccountFromId());
        payment.setAccountToId(dto.getAccountToId());
        payment.setAmount(dto.getAmount());

        dynamoDBMapper.save(payment);
    }

    @Override
    public void deletePayment(String id) {
        var payment = dynamoDBMapper.load(Payment.class, id);
        dynamoDBMapper.delete(payment);

    }
}
