package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Incoming;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IncomingRepository extends MongoRepository<Incoming, String> {
    Optional<Incoming> findByYearAndMonth(Integer year, Integer month);
    Optional<List<Incoming>> findByYear(Integer year);
}
