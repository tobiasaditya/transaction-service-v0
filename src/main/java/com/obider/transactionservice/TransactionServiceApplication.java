package com.obider.transactionservice;

import com.obider.transactionservice.middleware.AuthMiddleware;
import com.obider.transactionservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionServiceApplication {
	private final UserService userService;

	@Autowired
	public TransactionServiceApplication(UserService userService) {
		this.userService = userService;
	}
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthMiddleware> filterRegistrationBean(){
		FilterRegistrationBean<AuthMiddleware> registrationBean = new FilterRegistrationBean<>();
		AuthMiddleware authMiddleware = new AuthMiddleware(userService);
		registrationBean.setFilter(authMiddleware);
		registrationBean.addUrlPatterns("/api/v1/transaction/*");
		return registrationBean;

	}




}
