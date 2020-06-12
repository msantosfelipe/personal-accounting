package com.br.com.fms.personalaccounting.enums;

public enum GoalStatusEnum {
    PLANNED("Planejado"),
    ACTIVE("Ativo"),
    CONCLUDED("Concluído");

    private String value;

    GoalStatusEnum(String value) {
        this.value = value;
    }
}
