package com.br.com.fms.personalaccounting.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "strategy")
public class Strategy {
    @Id
    private String id;
    private String description;
    private LocalDate updateDate;
    private Boolean active;
}
