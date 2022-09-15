package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputTransaction;
import com.obider.transactionservice.enums.TransactionType;
import com.obider.transactionservice.model.Transaction;
import com.obider.transactionservice.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(String userId,InputTransaction input) {
        Transaction newTransaction = new Transaction(
                TransactionType.valueOf(input.getTrxType()),
                input.getAmount(),
                input.getDesc(),
                input.getTrxMethod(),
                userId,
                UUID.randomUUID().toString(),
                LocalDateTime.now()
        );
        newTransaction =  transactionRepository.insert(newTransaction);
        return newTransaction;
    }

    @Override
    public List<Transaction> getTransactions(String userId, LocalDate startDate, LocalDate endDate) {
        return transactionRepository.getUserTransactions(userId,startDate,endDate);
    }

    @Override
    public List<Transaction> getInvestments(String userId) {
        return transactionRepository.getUserInvestments(userId);
    }
}
