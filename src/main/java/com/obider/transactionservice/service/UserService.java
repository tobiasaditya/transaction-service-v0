package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputUser;
import com.obider.transactionservice.dto.LoginUser;
import com.obider.transactionservice.model.User;

import java.util.List;

public interface UserService {
    User createUser(InputUser input);
    List<User> getAllUser();
    User getUserById(String id);
    String loginUser(LoginUser input);
}
