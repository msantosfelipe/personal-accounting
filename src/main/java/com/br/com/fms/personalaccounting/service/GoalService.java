package com.br.com.fms.personalaccounting.service;

import com.br.com.fms.personalaccounting.model.Goal;

import java.util.List;

public interface GoalService {
    Goal create(Goal goal);
    List<Goal> findAll();
    Goal findById(String id);
    Goal update(Goal goal);
    void delete(String id);
}
