package com.br.com.fms.personalaccounting.model;

import lombok.Data;

import java.util.List;

@Data
public class Incoming {
    private String id;
    private Integer month;
    private Integer year;
    private List<Recipe> recipes;
}
