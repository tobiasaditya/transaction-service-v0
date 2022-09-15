package com.obider.transactionservice.exception;

public class RestExceptionUnauthorized extends RestExceptionBase{
    public RestExceptionUnauthorized(String message, String errorCode) {
        super(message, errorCode);
    }

    public RestExceptionUnauthorized(String message, String errorCode, Object args) {
        super(message, errorCode, args);
    }
}
