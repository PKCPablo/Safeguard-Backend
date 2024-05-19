package com.safeguard.safeguardbackend.rest;

import com.safeguard.safeguardbackend.model.Account;
import com.safeguard.safeguardbackend.rest.dto.CreateAccountRequest;
import com.safeguard.safeguardbackend.rest.dto.RetrieveAccountResponse;
import com.safeguard.safeguardbackend.rest.dto.RetrieveAccountsResponse;
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
public interface AccountController {

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    ResponseEntity<RetrieveAccountResponse> retrieveAccount(@PathVariable("id") String id);

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    ResponseEntity<RetrieveAccountsResponse> retrieveAccounts();

    @RequestMapping(path = "/account", method = RequestMethod.POST)
    ResponseEntity<Void> createAccount(@RequestBody CreateAccountRequest request);

    @RequestMapping(path = "/account/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAccount(@PathVariable("id") String id);
}
