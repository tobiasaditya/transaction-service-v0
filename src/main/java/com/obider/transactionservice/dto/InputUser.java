package com.obider.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
public class InputUser {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String password;
}
