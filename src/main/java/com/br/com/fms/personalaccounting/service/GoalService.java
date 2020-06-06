package com.br.com.fms.personalaccounting.service;

import com.br.com.fms.personalaccounting.model.Goal;

import java.util.List;

public interface GoalService {
    Goal create(Goal account);
    List<Goal> findAll();
    Goal findById(String id);
    Goal update(Goal account);
    void delete(String id);
}
