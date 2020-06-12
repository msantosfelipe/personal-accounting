package com.br.com.fms.personalaccounting.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Income {
    private BigDecimal value;
    private BigDecimal discounts;
    private String description;
    private Boolean isPrincipalIncome;
    private Integer day;
}
