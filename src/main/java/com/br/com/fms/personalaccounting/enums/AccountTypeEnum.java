package com.br.com.fms.personalaccounting.enums;

public enum AccountTypeEnum {

    CONTA_CORRENTE("Conta Corrente"),
    INVESTIMENTO("Investimento");

    private String value;

    AccountTypeEnum(String value) {
        this.value = value;
    }

}
