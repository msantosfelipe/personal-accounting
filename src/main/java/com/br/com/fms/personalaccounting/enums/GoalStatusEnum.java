package com.br.com.fms.personalaccounting.enums;

public enum GoalStatusEnum {
    PLANNED("Planejado"),
    ATIVO("Ativo"),
    CONCLUDED("Concluído");

    private String value;

    GoalStatusEnum(String value) {
        this.value = value;
    }
}
