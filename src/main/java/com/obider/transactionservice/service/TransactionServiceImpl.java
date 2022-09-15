package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.model.Transaction;
import com.obider.transactionservice.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(InputTransaction input) {
        return null;
    }

    @Override
    public List<Transaction> getTransactions(String userId) {
        return null;
    }

    @Override
    public List<Transaction> getInvestments(String userId) {
        return null;
    }
}
