package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputUser;
import com.obider.transactionservice.model.User;

import java.util.List;

public interface UserService {
    User createUser(InputUser inputUser);
    List<User> getAllUser();
    User getUserById(String id);
}
