package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByName(String name);
}
