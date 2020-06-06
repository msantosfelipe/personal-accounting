package com.br.com.fms.personalaccounting.service;

import com.br.com.fms.personalaccounting.model.Incoming;

import java.util.List;

public interface IncomingService {
    Incoming create(Incoming incoming);
    List<Incoming> findAll();
    Incoming findById(String id);
    Incoming findByYearAndMonth(Integer year, Integer month);
    List<Incoming> findByYear(Integer year);
    Incoming update(Incoming incoming);
    void delete(String id);
}
