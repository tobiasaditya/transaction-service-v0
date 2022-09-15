package com.obider.transactionservice.exception;

public class RestExceptionNotFound extends RestExceptionBase{
    public RestExceptionNotFound(String message, String errorCode) {
        super(message, errorCode);
    }

    public RestExceptionNotFound(String message, String errorCode, Object args) {
        super(message, errorCode, args);
    }
}
