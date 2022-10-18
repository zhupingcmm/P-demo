package com.mf.exception;

public class MyException extends RuntimeException{

    private int code;
    private String message;

    private ExceptionEnum exceptionEnum;


    public MyException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
        this.exceptionEnum = exceptionEnum;
    }

    public MyException (Exception e) {
        this.message = e.getMessage();
    }
}
