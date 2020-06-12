package com.br.com.fms.personalaccounting.service.impl;

import com.br.com.fms.personalaccounting.model.Strategy;
import com.br.com.fms.personalaccounting.repository.StrategyRepository;
import com.br.com.fms.personalaccounting.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    private static final String STRATEGY_NOT_FOUND = "Strategy not found";

    @Override
    public Strategy create(Strategy strategy) {
        strategy.setId(null);
        strategy.setUpdateDate(LocalDate.now());
        return strategyRepository.save(strategy);
    }

    @Override
    public List<Strategy> findAll() {
        return strategyRepository.findAll();
    }

    @Override
    public Strategy findById(String id) {
        Optional<Strategy> entity = strategyRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, STRATEGY_NOT_FOUND);
        }

        return entity.get();
    }


    @Override
    public Strategy update(Strategy strategy) {
        Optional<Strategy> entity = strategyRepository.findById(strategy.getId());

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, STRATEGY_NOT_FOUND);
        }
        strategy.setUpdateDate(LocalDate.now());

        return strategyRepository.save(strategy);
    }

    @Override
    public void delete(String id) {
        Optional<Strategy> entity = strategyRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, STRATEGY_NOT_FOUND);
        }

        strategyRepository.delete(entity.get());
    }

    @Override
    public void activate(String id) {
        Optional<Strategy> optionalEntity = strategyRepository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, STRATEGY_NOT_FOUND);
        }

        Strategy entity = optionalEntity.get();
        entity.setActive(true);
        entity.setUpdateDate(LocalDate.now());
        strategyRepository.save(entity);
    }
}
