package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    Transaction addTransaction(String userId, InputTransaction input);
    List<Transaction> getTransactions(String userId, LocalDate startDate, LocalDate endDate);
    List<Transaction> getInvestments(String userId);
}
