package com.obider.transactionservice.repository;

import com.obider.transactionservice.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction,String> {
    @Query(value = "{'userId':?0}")
    List<Transaction> getUserTransactions(String userId);
}
