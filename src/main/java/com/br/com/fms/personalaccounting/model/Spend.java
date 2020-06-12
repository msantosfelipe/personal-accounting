package com.br.com.fms.personalaccounting.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Spend {
    private BigDecimal value;
    private String description;
    private String type;
    private Boolean isFixSpend;
    private Integer day;
}
