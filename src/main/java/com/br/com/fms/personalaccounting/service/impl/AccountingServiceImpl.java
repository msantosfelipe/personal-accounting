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

    @Override
    public Account create(Account account) {
        Optional<Account> accountEntity = accountRepository.findByName(account.getName());

        if (accountEntity.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Account already exists");
        }

        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(String id) {
        Optional<Account> accountEntity = accountRepository.findById(id);

        if (accountEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Account not found");
        }

        return accountEntity.get();
    }

    @Override
    public Account update(Account account) {
        Optional<Account> accountEntity = accountRepository.findById(account.getId());

        if (accountEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Account not found");
        }

        return accountRepository.save(account);
    }

    @Override
    public void delete(String id) {
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()) {
            accountRepository.delete(account.get());
        }
    }
}
