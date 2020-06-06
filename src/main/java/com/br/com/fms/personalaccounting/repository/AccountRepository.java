package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
}
