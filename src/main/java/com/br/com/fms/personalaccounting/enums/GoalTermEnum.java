package com.br.com.fms.personalaccounting.enums;

public enum GoalTermEnum {
    SHORT_TERM("Curto prazo"),
    MID_TERM0("Médio prazo"),
    LONG_TERM("Longo prazo");

    private String value;

    GoalTermEnum(String value) {
        this.value = value;
    }
}
