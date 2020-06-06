package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByName(String name);
}
