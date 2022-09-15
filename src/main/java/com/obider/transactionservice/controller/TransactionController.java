package com.obider.transactionservice.controller;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.exception.RestExceptionConstants;
import com.obider.transactionservice.exception.RestExceptionUnprocessableEntity;
import com.obider.transactionservice.model.Transaction;
import com.obider.transactionservice.model.User;
import com.obider.transactionservice.responses.ResponsesHandler;
import com.obider.transactionservice.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createTransaction(
            HttpServletRequest request,
            @Valid @RequestBody InputTransaction inputTransaction, BindingResult bindingResult){
        //Check validation error
        if (bindingResult.hasErrors()){
            throw new RestExceptionUnprocessableEntity("Invalid input", RestExceptionConstants.USR202_02,bindingResult.getAllErrors());
        }

        //Get current user
        User currentUser = (User) request.getAttribute("user");
        Transaction newTransaction = transactionService.addTransaction(currentUser.getId(),inputTransaction);
        return ResponsesHandler.generateResponse("Success create transaction", HttpStatus.OK,newTransaction);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getTransactions(HttpServletRequest request){
        User currentUser = (User) request.getAttribute("user");
        List<Transaction> transactions = transactionService.getTransactions(currentUser.getId());
        return ResponsesHandler.generateResponse("Success get transactions", HttpStatus.OK,transactions);
    }
}
