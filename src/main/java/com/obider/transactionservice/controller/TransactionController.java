package com.obider.transactionservice.controller;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.exception.RestExceptionConstants;
import com.obider.transactionservice.exception.RestExceptionUnprocessableEntity;
import com.obider.transactionservice.model.Transaction;
import com.obider.transactionservice.model.User;
import com.obider.transactionservice.responses.ResponsesHandler;
import com.obider.transactionservice.service.TransactionService;
import com.obider.transactionservice.utils.DateFormatter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
            throw new RestExceptionUnprocessableEntity("Invalid input", RestExceptionConstants.TRX401_01,bindingResult.getAllErrors());
        }

        //Get current user
        User currentUser = (User) request.getAttribute("user");
        Transaction newTransaction = transactionService.addTransaction(currentUser.getId(),inputTransaction);
        return ResponsesHandler.generateResponse("Success create transaction", HttpStatus.OK,newTransaction);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getTransactions(
            HttpServletRequest request,
            @RequestParam(value = "startDate",required = false)String inputStartDate,
            @RequestParam(value = "endDate",required = false)String inputEndDate
            ){
        LocalDate now = LocalDate.now();
        //Default startDate = Start date of this month
        LocalDate startDate = inputStartDate==null? LocalDate.of(now.getYear(),now.getMonth(),1) : DateFormatter.parseStringToDate(inputStartDate);
        //Default endDate = Start date of next month
        LocalDate endDate = inputEndDate==null? LocalDate.of(now.getYear(),now.getMonth().plus(1),1) : DateFormatter.parseStringToDate(inputEndDate);
        System.out.println(startDate);
        System.out.println(endDate);
        if(startDate==null || endDate==null){
            throw new RestExceptionUnprocessableEntity("Invalid date input", RestExceptionConstants.TRX401_01);
        } else if (
                startDate.getYear() != endDate.getYear() || endDate.getMonthValue() - startDate.getMonthValue() > 2){
            throw new RestExceptionUnprocessableEntity("Invalid range date", RestExceptionConstants.TRX401_01);
        }

        User currentUser = (User) request.getAttribute("user");
        List<Transaction> transactions = transactionService.getTransactions(currentUser.getId(),startDate,endDate);
        return ResponsesHandler.generateResponse("Success get transactions", HttpStatus.OK,transactions);
    }

    @GetMapping(path = "/investment")
    public ResponseEntity<Object> getInvestments(HttpServletRequest request){
        User currentUser = (User) request.getAttribute("user");
        List<Transaction> investments = transactionService.getInvestments(currentUser.getId());
        return ResponsesHandler.generateResponse("Success get investments", HttpStatus.OK,investments);
    }
}
