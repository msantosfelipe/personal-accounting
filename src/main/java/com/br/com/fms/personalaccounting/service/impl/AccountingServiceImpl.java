package com.br.com.fms.personalaccounting.service.impl;

import com.br.com.fms.personalaccounting.model.Account;
import com.br.com.fms.personalaccounting.repository.AccountRepository;
import com.br.com.fms.personalaccounting.service.AccoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingServiceImpl implements AccoutingService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
