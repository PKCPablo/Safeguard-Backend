package com.safeguard.safeguardbackend.rest.impl;

import com.safeguard.safeguardbackend.model.Account;
import com.safeguard.safeguardbackend.rest.AccountController;
import com.safeguard.safeguardbackend.rest.dto.CreateAccountRequest;
import com.safeguard.safeguardbackend.rest.dto.RetrieveAccountResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrieveAccountsResponse;
import com.safeguard.safeguardbackend.service.AccountService;
import com.safeguard.safeguardbackend.service.dto.CreateAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AccountControllerImpl implements AccountController {

    @Autowired
    AccountService accountService;

    @Override
    public ResponseEntity<RetrieveAccountResponse> retrieveAccount(String id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user ID");
        }
        var response = new RetrieveAccountResponse(accountService.retrieveAccount(id));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<RetrieveAccountsResponse> retrieveAccounts() {
        var list = accountService.retrieveAccounts();
        var response = new RetrieveAccountsResponse();

        response.setNumOfResults(list.size());
        response.setAccounts(list.stream().map(RetrieveAccountResponse::new).toList());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> createAccount(CreateAccountRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account on request");
        }
        accountService.createAccount(new CreateAccountDTO(request));
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteAccount(String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok(null);
    }
}
