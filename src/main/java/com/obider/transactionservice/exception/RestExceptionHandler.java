package com.obider.transactionservice.exception;

import com.obider.transactionservice.responses.ResponsesHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {RestExceptionBadRequest.class})
    public ResponseEntity<Object> handleBadRequestException(RestExceptionBadRequest e){
        return ResponsesHandler.generateResponseError(e,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RestExceptionUnprocessableEntity.class})
    public ResponseEntity<Object> handleBadRequestException(RestExceptionUnprocessableEntity e){
        return ResponsesHandler.generateResponseError(e,HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
