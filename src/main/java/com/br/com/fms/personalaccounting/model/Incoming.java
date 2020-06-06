package com.br.com.fms.personalaccounting.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "incoming")
public class Incoming {
    @Id
    private String id;
    private Integer year;
    private Integer month;
    private List<Recipe> recipes;
}
