package com.br.com.fms.personalaccounting.controller;

import com.br.com.fms.personalaccounting.model.Goal;
import com.br.com.fms.personalaccounting.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/goal")
public class GoalController {

    @Autowired
    GoalService goalService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Goal create(@RequestBody Goal goal) {
        return goalService.create(goal);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Goal> findAll() {
        return goalService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Goal findById(@PathVariable("id") String id) {
        return goalService.findById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Goal update(@RequestBody Goal goal) {
        return goalService.update(goal);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        goalService.delete(id);
    }

}
