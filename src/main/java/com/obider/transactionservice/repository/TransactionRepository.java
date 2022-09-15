package com.obider.transactionservice.repository;

import com.obider.transactionservice.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction,String> {
}
