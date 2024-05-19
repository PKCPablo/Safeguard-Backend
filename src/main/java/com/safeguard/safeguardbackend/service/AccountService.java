package com.safeguard.safeguardbackend.service;

import com.safeguard.safeguardbackend.model.Account;
import com.safeguard.safeguardbackend.service.dto.CreateAccountDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountService {

    @Transactional(readOnly = true)
    Account retrieveAccount(String id);

    @Transactional(readOnly = true)
    List<Account> retrieveAccounts();

    @Transactional(readOnly = false)
    void createAccount(CreateAccountDTO dto);

    @Transactional(readOnly = false)
    void deleteAccount(String id);
}
