package com.safeguard.safeguardbackend.service.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.safeguard.safeguardbackend.model.Account;
import com.safeguard.safeguardbackend.service.AccountService;
import com.safeguard.safeguardbackend.service.dto.CreateAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Override
    public Account retrieveAccount(String id) {
        return dynamoDBMapper.load(Account.class, id);
    }

    @Override
    public List<Account> retrieveAccounts() {
        return dynamoDBMapper.scan(Account.class, new DynamoDBScanExpression());
    }

    @Override
    public void createAccount(CreateAccountDTO dto) {
        var account = new Account();

        account.setId(dto.getId());
        account.setUserId(dto.getUserId());
        account.setBalance(dto.getBalance());

        dynamoDBMapper.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        var account = dynamoDBMapper.load(Account.class, id);
        dynamoDBMapper.delete(account);
    }
}
