package com.br.com.fms.personalaccounting.controller;

import com.br.com.fms.personalaccounting.model.Spending;
import com.br.com.fms.personalaccounting.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/spending")
public class SpendingController {

    @Autowired
    SpendingService spendingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Spending create(@RequestBody Spending spending) {
        return spendingService.create(spending);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Spending> findAll() {
        return spendingService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Spending findById(@PathVariable("id") String id) {
        return spendingService.findById(id);
    }

    @GetMapping(value = "/year/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Spending findByYearAndMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return spendingService.findByYearAndMonth(year, month);
    }

    @GetMapping(value = "/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Spending> findByYear(@PathVariable("year") Integer year) {
        return spendingService.findByYear(year);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Spending update(@RequestBody Spending spending) {
        return spendingService.update(spending);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        spendingService.delete(id);
    }

}

