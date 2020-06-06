package com.br.com.fms.personalaccounting.enums;

public enum AccountTypeEnum {
    CURRENT_ACCOUNT("Conta Corrente"),
    INVESTIMENT("Investimento");

    private String value;

    AccountTypeEnum(String value) {
        this.value = value;
    }

}
