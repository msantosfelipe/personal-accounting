package com.br.com.fms.personalaccounting.controller;

import com.br.com.fms.personalaccounting.model.Account;
import com.br.com.fms.personalaccounting.service.AccoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounting")
public class AccountingController {

    @Autowired
    AccoutingService accoutingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        return accoutingService.create(account);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAll() {
        return accoutingService.findAll();
    }
}
