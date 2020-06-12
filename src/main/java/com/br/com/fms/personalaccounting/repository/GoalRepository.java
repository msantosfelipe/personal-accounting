package com.br.com.fms.personalaccounting.repository;

import com.br.com.fms.personalaccounting.model.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {
}
