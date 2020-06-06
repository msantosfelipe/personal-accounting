package com.br.com.fms.personalaccounting.service;

import com.br.com.fms.personalaccounting.model.Account;

import java.util.List;

public interface AccoutingService {
    Account create(Account account);
    List<Account> findAll();
    Account findById(String id);
    Account update(Account account);
    void delete(String id);

}
