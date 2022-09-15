package com.obider.transactionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String phoneNumber;
    private String token;
    private LocalDateTime createTime;
    private String password;

    public User(String firstName, String lastName, String email, String phoneNumber, String token, LocalDateTime createTime, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.createTime = createTime;
        this.password = password;
    }
}
