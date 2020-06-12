package com.br.com.fms.personalaccounting.controller;

import com.br.com.fms.personalaccounting.model.Strategy;
import com.br.com.fms.personalaccounting.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/strategy")
public class StrategyController {

    @Autowired
    StrategyService strategyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Strategy create(@RequestBody Strategy strategy) {
        return strategyService.create(strategy);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Strategy> findAll() {
        return strategyService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Strategy findById(@PathVariable("id") String id) {
        return strategyService.findById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Strategy update(@RequestBody Strategy strategy) {
        return strategyService.update(strategy);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        strategyService.delete(id);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void activate(@PathVariable("id") String id) {
        strategyService.activate(id);
    }

}
