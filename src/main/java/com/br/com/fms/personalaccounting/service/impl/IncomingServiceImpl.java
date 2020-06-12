package com.br.com.fms.personalaccounting.service.impl;

import com.br.com.fms.personalaccounting.model.Incoming;
import com.br.com.fms.personalaccounting.repository.IncomingRepository;
import com.br.com.fms.personalaccounting.service.IncomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class IncomingServiceImpl implements IncomingService {

    @Autowired
    private IncomingRepository incomingRepository;

    private static final String INCOMING_NOT_FOUND = "Incoming not found";

    @Override
    public Incoming create(Incoming incoming) {
        Optional<Incoming> optionalEntity = incomingRepository.findByYearAndMonth(incoming.getYear(), incoming.getMonth());

        if (optionalEntity.isPresent()) {
            Incoming entity = optionalEntity.get();
            entity.getIncomes().addAll(incoming.getIncomes());
            return incomingRepository.save(entity);
        } else {
            incoming.setId(null);
            return incomingRepository.save(incoming);
        }
    }

    @Override
    public List<Incoming> findAll() {
        return incomingRepository.findAll();
    }

    @Override
    public Incoming findById(String id) {
        Optional<Incoming> entity = incomingRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, INCOMING_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public Incoming findByYearAndMonth(Integer year, Integer month) {
        Optional<Incoming> entity = incomingRepository.findByYearAndMonth(year, month);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, INCOMING_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public List<Incoming> findByYear(Integer year) {
        Optional<List<Incoming>> entity = incomingRepository.findByYear(year);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, INCOMING_NOT_FOUND);
        }

        return entity.get();
    }

    @Override
    public Incoming update(Incoming incoming) {
        Optional<Incoming> entity = incomingRepository.findById(incoming.getId());

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, INCOMING_NOT_FOUND);
        }

        return incomingRepository.save(incoming);
    }

    @Override
    public void delete(String id) {
        Optional<Incoming> entity = incomingRepository.findById(id);

        if (entity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, INCOMING_NOT_FOUND);
        }

        incomingRepository.delete(entity.get());
    }

}
