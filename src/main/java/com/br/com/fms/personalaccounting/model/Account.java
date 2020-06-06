package com.br.com.fms.personalaccounting.model;

import com.br.com.fms.personalaccounting.enums.AccountTypeEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "account")
public class Account {
    @Id
    private String id;
    private String name;
    private AccountTypeEnum type;
    private String description;
    private String code;
    private String agencyNumber;
    private String acountNumber;
    // TODO store passwords
}
