package com.obider.transactionservice.exception;

public class RestExceptionBadRequest extends RuntimeException{
    private String errorCode;

    public RestExceptionBadRequest(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
