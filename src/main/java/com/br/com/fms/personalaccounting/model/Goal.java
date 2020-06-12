package com.br.com.fms.personalaccounting.model;

import com.br.com.fms.personalaccounting.enums.GoalStatusEnum;
import com.br.com.fms.personalaccounting.enums.GoalTermEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "goal")
public class Goal {
    @Id
    private String id;
    private String description;
    private GoalTermEnum term;
    private GoalStatusEnum status;
    private String expectedDate;
}
