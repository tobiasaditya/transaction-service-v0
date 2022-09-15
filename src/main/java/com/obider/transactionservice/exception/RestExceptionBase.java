package com.obider.transactionservice.exception;

public class RestExceptionBase extends RuntimeException{
    private String errorCode;
    private Object args;

    public RestExceptionBase(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public RestExceptionBase(String message, String errorCode, Object args) {
        super(message);
        this.errorCode = errorCode;
        this.args = args;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Object getArgs() {
        return args;
    }
}
