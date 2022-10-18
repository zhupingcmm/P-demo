package com.mf.exception;

public class Test {
    public static void main(String[] args) {
        throw new MyException(ExceptionEnum.SYSTEM_ERROR);
//        System.out.println(myException);
    }
}
