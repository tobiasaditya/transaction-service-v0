package com.obider.transactionservice.responses;

import com.obider.transactionservice.exception.RestExceptionBadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponsesHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object obj){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", obj);

        return new ResponseEntity<Object>(map,status);
    }
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", null);

        return new ResponseEntity<Object>(map,status);
    }
    public static ResponseEntity<Object> generateResponseError(RestExceptionBadRequest errorObj, HttpStatus status){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status.value());
        map.put("message", errorObj.getMessage());
        map.put("data", null);

        Map<String,String> errorMap = new LinkedHashMap<>();
        errorMap.put("code",errorObj.getErrorCode());
        errorMap.put("message",errorObj.getMessage());
        map.put("error",errorMap);

        return new ResponseEntity<Object>(map,status);
    }
}
