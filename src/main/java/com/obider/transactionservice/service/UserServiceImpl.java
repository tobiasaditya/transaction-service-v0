package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputUser;
import com.obider.transactionservice.dto.LoginUser;
import com.obider.transactionservice.exception.RestExceptionBadRequest;
import com.obider.transactionservice.exception.RestExceptionConstants;
import com.obider.transactionservice.exception.RestExceptionNotFound;
import com.obider.transactionservice.exception.RestExceptionUnauthorized;
import com.obider.transactionservice.model.User;
import com.obider.transactionservice.repository.UserRepository;
import com.obider.transactionservice.security.HashPassword;
import com.obider.transactionservice.security.JwtToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User createUser(InputUser inputUser) {
        //Check for duplicate
        User foundUser = getUserByPhone(inputUser.getPhoneNumber());
        if (foundUser!= null){
            throw new RestExceptionBadRequest("duplicate username", RestExceptionConstants.USR202_01);
        }
        User newUser = new User(
                inputUser.getFirstName(),
                inputUser.getLastName(),
                inputUser.getEmail(),
                inputUser.getPhoneNumber(),
                "",
                LocalDateTime.now(),
                HashPassword.hashedPassword(inputUser.getPassword())
        );
        userRepository.insert(newUser);
        return newUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()){
            throw new RestExceptionNotFound("user not found",RestExceptionConstants.USR202_03,id);
        }
        return foundUser.get();
    }

    @Override
    public String loginUser(LoginUser input) {
        User foundUser = getUserByPhone(input.getUsername());
        if (foundUser==null){
            throw new RestExceptionUnauthorized("incorrect username/password 1",RestExceptionConstants.USR401_01);
        }

        if (!HashPassword.verifyPassword(input.getPassword(),foundUser.getPassword())){
            throw new RestExceptionUnauthorized("incorrect username/password 2",RestExceptionConstants.USR401_02);
        }
        return JwtToken.generate(foundUser);
    }

    private User getUserByPhone(String phoneNumber) {
        Optional<User> foundUser = userRepository.findByPhoneNumber(phoneNumber);
        if (foundUser.isEmpty()){
            return null;
        }
        return foundUser.get();
    }
}
