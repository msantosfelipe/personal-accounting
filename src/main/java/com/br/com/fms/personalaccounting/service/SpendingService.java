package com.br.com.fms.personalaccounting.service;

import com.br.com.fms.personalaccounting.model.Spending;

import java.util.List;

public interface SpendingService {
    Spending create(Spending spending);
    List<Spending> findAll();
    Spending findById(String id);
    Spending findByYearAndMonth(Integer year, Integer month);
    List<Spending> findByYear(Integer year);
    Spending update(Spending spending);
    void delete(String id);

}
