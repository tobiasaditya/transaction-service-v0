package com.obider.transactionservice.controller;

import com.obider.transactionservice.dto.InputUser;
import com.obider.transactionservice.exception.RestExceptionBadRequest;
import com.obider.transactionservice.exception.RestExceptionConstants;
import com.obider.transactionservice.exception.RestExceptionUnprocessableEntity;
import com.obider.transactionservice.model.User;
import com.obider.transactionservice.responses.ResponsesHandler;
import com.obider.transactionservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAllUsers(){
        List<User> users =  userService.getAllUser();
        return ResponsesHandler.generateResponse("Success get all users", HttpStatus.OK,users);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody InputUser inputUser, BindingResult bindingResult){
        //Check validation error
        if (bindingResult.hasErrors()){
            throw new RestExceptionUnprocessableEntity("Invalid input", RestExceptionConstants.USR202_02,bindingResult.getAllErrors());
        }
        User newUser = userService.createUser(inputUser);
        return ResponsesHandler.generateResponse("Success create new user", HttpStatus.OK,newUser);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") String userId){
        User foundUser = userService.getUserById(userId);
        return ResponsesHandler.generateResponse("Success get user", HttpStatus.OK,foundUser);
    }
}
