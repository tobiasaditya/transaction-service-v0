package com.obider.transactionservice.service;

import com.obider.transactionservice.dto.InputUser;
import com.obider.transactionservice.exception.RestExceptionBadRequest;
import com.obider.transactionservice.exception.RestExceptionConstants;
import com.obider.transactionservice.model.User;
import com.obider.transactionservice.repository.UserRepository;
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
                inputUser.getPassword()
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
        return null;
    }

    @Override
    public User getUserByPhone(String phoneNumber) {
        Optional<User> foundUser = userRepository.findByPhoneNumber(phoneNumber);
        if (foundUser.isEmpty()){
            return null;
        }
        return foundUser.get();
    }
}
