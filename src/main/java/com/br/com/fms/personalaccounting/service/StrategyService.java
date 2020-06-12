package com.br.com.fms.personalaccounting.service;

import com.br.com.fms.personalaccounting.model.Strategy;

import java.util.List;

public interface StrategyService {
    Strategy create(Strategy strategy);
    List<Strategy> findAll();
    Strategy findById(String id);
    Strategy update(Strategy strategy);
    void delete(String id);
    void activate(String id);
}
