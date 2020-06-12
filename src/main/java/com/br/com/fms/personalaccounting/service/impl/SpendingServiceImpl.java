package com.br.com.fms.personalaccounting.service.impl;

import com.br.com.fms.personalaccounting.model.Spending;
import com.br.com.fms.personalaccounting.repository.SpendingRepository;
import com.br.com.fms.personalaccounting.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class SpendingServiceImpl implements SpendingService {
    
    @Autowired
    private SpendingRepository spendingRepository;

    private static final String SPENDING_NOT_FOUND = "Spending not found";

    @Override
    public Spending create(Spending spending) {
        Optional<Spending> optionalEntity = spendingRepository.findByYearAndMonth(spending.getYear(), spending.getMonth());

        if (optionalEntity.isPresent()) {
            Spending entity = optionalEntity.get();
            entity.getSpending().addAll(spending.getSpending());
            return spendingRepository.save(entity);
        } else {
            spending.setId(null);
            return spendingRepository.save(spending);
        }

    }

    @Override
    public List<Spending> findAll() {
        return spendingRepository.findAll();
    }

    @Override
    public Spending findById(String id) {
        Optional<Spending> entity = spendingRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, SPENDING_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public Spending findByYearAndMonth(Integer year, Integer month) {
        Optional<Spending> entity = spendingRepository.findByYearAndMonth(year, month);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, SPENDING_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public List<Spending> findByYear(Integer year) {
        Optional<List<Spending>> entity = spendingRepository.findByYear(year);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, SPENDING_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public Spending update(Spending spending) {
        Optional<Spending> entity = spendingRepository.findById(spending.getId());

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, SPENDING_NOT_FOUND);
        }

        return spendingRepository.save(spending);
    }

    @Override
    public void delete(String id) {
        Optional<Spending> entity = spendingRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, SPENDING_NOT_FOUND);
        }

        spendingRepository.delete(entity.get());
    }
}
