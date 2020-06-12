package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Strategy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StrategyRepository extends MongoRepository<Strategy, String> {
}
