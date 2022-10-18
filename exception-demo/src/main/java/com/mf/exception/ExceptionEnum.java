package com.mf.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionEnum {

    SYSTEM_ERROR(1, "system error");


    @Getter
    private int code;

    @Getter
    private String message;
}
