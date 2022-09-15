package com.obider.transactionservice.controller;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.model.Transaction;
import com.obider.transactionservice.responses.ResponsesHandler;
import com.obider.transactionservice.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createTransaction(InputTransaction inputTransaction){
        Transaction newTransaction = transactionService.addTransaction(inputTransaction);
        return ResponsesHandler.generateResponse("Success create transaction", HttpStatus.OK,newTransaction);
    }
}
