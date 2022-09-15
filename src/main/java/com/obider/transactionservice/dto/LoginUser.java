package com.obider.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class LoginUser {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
