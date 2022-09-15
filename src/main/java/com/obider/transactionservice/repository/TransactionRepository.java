package com.obider.transactionservice.repository;

import com.obider.transactionservice.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction,String> {
    @Query(value = "{ 'userId' : ?0 , 'requestTime' : { $gte : ?1 , $lte : ?2} }")
    List<Transaction> getUserTransactions(String userId, LocalDate startDate, LocalDate endDate);
}
