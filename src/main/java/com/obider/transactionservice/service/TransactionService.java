package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(InputTransaction input);
    List<Transaction> getTransactions(String userId);
    List<Transaction> getInvestments(String userId);
}
