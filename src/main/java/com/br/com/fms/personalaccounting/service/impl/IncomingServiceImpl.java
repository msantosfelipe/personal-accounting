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

    @Override
    public Incoming create(Incoming incoming) {
        Optional<Incoming> accountEntity = incomingRepository.findByYearAndMonth(incoming.getYear(), incoming.getMonth());

        if (accountEntity.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Incoming already exists");
        }

        return incomingRepository.save(incoming);
    }

    @Override
    public List<Incoming> findAll() {
        return incomingRepository.findAll();
    }

    @Override
    public Incoming findById(String id) {
        Optional<Incoming> incomingEntity = incomingRepository.findById(id);

        if (incomingEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Incoming not found");
        }

        return incomingEntity.get();
    }

    @Override
    public Incoming findByYearAndMonth(Integer year, Integer month) {
        Optional<Incoming> incomingEntity = incomingRepository.findByYearAndMonth(year, month);

        if (incomingEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Incoming not found");
        }

        return incomingEntity.get();
    }

    @Override
    public List<Incoming> findByYear(Integer year) {
        Optional<List<Incoming>> incomingEntity = incomingRepository.findByYear(year);

        if (incomingEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Incoming not found");
        }

        return incomingEntity.get();
    }

    @Override
    public Incoming update(Incoming incoming) {
        Optional<Incoming> incomingEntity = incomingRepository.findById(incoming.getId());

        if (incomingEntity.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Incoming not found");
        }

        return incomingRepository.save(incoming);
    }

    @Override
    public void delete(String id) {
        Optional<Incoming> incoming = incomingRepository.findById(id);

        if (incoming.isPresent()) {
            incomingRepository.delete(incoming.get());
        }
    }
}
