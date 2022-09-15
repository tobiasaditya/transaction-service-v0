package com.obider.transactionservice.exception;

public class RestExceptionUnprocessableEntity extends RestExceptionBase{
    public RestExceptionUnprocessableEntity(String message, String errorCode) {
        super(message, errorCode);
    }

    public RestExceptionUnprocessableEntity(String message, String errorCode, Object args) {
        super(message, errorCode, args);
    }
}
