package com.obider.transactionservice.exception;

public class RestExceptionBadRequest extends RestExceptionBase{
    public RestExceptionBadRequest(String message, String errorCode) {
        super(message, errorCode);
    }

    public RestExceptionBadRequest(String message, String errorCode, Object args) {
        super(message, errorCode, args);
    }
}
