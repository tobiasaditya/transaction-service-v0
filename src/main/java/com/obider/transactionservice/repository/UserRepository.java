package com.obider.transactionservice.repository;

import com.obider.transactionservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
