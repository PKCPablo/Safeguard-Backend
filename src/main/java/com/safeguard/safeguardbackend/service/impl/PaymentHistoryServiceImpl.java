package com.safeguard.safeguardbackend.service.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.safeguard.safeguardbackend.model.PaymentHistory;
import com.safeguard.safeguardbackend.service.PaymentHistoryService;
import com.safeguard.safeguardbackend.service.dto.CreatePaymentHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Override
    public PaymentHistory retrievePaymentHistory(String id) {
        return dynamoDBMapper.load(PaymentHistory.class, id);
    }

    @Override
    public List<PaymentHistory> retrievePaymentHistories() {
        return dynamoDBMapper.scan(PaymentHistory.class, new DynamoDBScanExpression());
    }

    @Override
    public void createPaymentHistory(CreatePaymentHistoryDTO dto) {
        var paymentHistory = new PaymentHistory();

        paymentHistory.setId(dto.getId());
        paymentHistory.setUserId(dto.getUserId());
        paymentHistory.setPaymentsId(dto.getPaymentsId());

        dynamoDBMapper.save(paymentHistory);
    }

    @Override
    public void deletePaymentHistory(String id) {
        var paymentHistory = dynamoDBMapper.load(PaymentHistory.class, id);
        dynamoDBMapper.delete(paymentHistory);
    }
}
