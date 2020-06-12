package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Spending;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SpendingRepository extends MongoRepository<Spending, String> {
    Optional<Spending> findByYearAndMonth(Integer year, Integer month);
    Optional<List<Spending>> findByYear(Integer year);
}
