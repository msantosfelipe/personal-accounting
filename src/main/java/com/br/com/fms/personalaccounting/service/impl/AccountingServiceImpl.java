package com.br.com.fms.personalaccounting.service.impl;

import com.br.com.fms.personalaccounting.model.Account;
import com.br.com.fms.personalaccounting.repository.AccountRepository;
import com.br.com.fms.personalaccounting.service.AccoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountingServiceImpl implements AccoutingService {

    @Autowired
    private AccountRepository accountRepository;

    private static final String ACCOUNT_ALREADY_EXISTS = "Account already exists";
    private static final String ACCOUNT_NOT_FOUND = "Account not found";

    @Override
    public Account create(Account account) {
        Optional<Account> entity = accountRepository.findByName(account.getName());

        if (entity.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, ACCOUNT_ALREADY_EXISTS);
        }

        account.setId(null);

        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(String id) {
        Optional<Account> entity = accountRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, ACCOUNT_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public Account update(Account account) {
        Optional<Account> entity = accountRepository.findById(account.getId());

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, ACCOUNT_NOT_FOUND);
        }

        return accountRepository.save(account);
    }

    @Override
    public void delete(String id) {
        Optional<Account> entity = accountRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, ACCOUNT_NOT_FOUND);
        }

        accountRepository.delete(entity.get());
    }
}
