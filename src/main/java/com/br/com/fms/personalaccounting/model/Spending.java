package com.br.com.fms.personalaccounting.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document(collection = "spending")
public class Spending {
    @Id
    private String id;
    private Integer year;
    private Integer month;
    private List<Spend> spending;
    private BigDecimal totalspendingValue;

    public BigDecimal getTotalspendingValue() {
        if (this.spending != null) {
            BigDecimal total = new BigDecimal(0);
            return this.spending.stream().map(i -> i.getValue()).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        }

        return new BigDecimal(0);
    }

}
