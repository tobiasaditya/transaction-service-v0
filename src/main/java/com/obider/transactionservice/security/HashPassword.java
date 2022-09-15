package com.obider.transactionservice.security;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {
    public static String hashedPassword(String plain){
        return BCrypt.hashpw(plain,BCrypt.gensalt(10));
    }

    public static boolean verifyPassword(String plain, String hashed){
        return BCrypt.checkpw(plain,hashed);
    }
}
