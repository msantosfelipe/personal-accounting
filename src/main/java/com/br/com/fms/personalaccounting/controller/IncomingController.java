package com.br.com.fms.personalaccounting.controller;

import com.br.com.fms.personalaccounting.model.Account;
import com.br.com.fms.personalaccounting.model.Incoming;
import com.br.com.fms.personalaccounting.service.AccoutingService;
import com.br.com.fms.personalaccounting.service.IncomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/incommings")
public class IncomingController {

    @Autowired
    IncomingService incomingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Incoming create(@RequestBody Incoming incoming) {
        return incomingService.create(incoming);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Incoming> findAll() {
        return incomingService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Incoming findById(@PathVariable("id") String id) {
        return incomingService.findById(id);
    }

    @GetMapping(value = "/year/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Incoming findByYearAndMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        return incomingService.findByYearAndMonth(year, month);
    }

    @GetMapping(value = "/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Incoming> findByYear(@PathVariable("year") Integer year) {
        return incomingService.findByYear(year);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Incoming update(@RequestBody Incoming incoming) {
        return incomingService.update(incoming);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        incomingService.delete(id);
    }

}
