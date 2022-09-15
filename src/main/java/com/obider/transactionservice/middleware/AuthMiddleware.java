package com.obider.transactionservice.middleware;

import com.obider.transactionservice.model.User;
import com.obider.transactionservice.security.JwtToken;
import com.obider.transactionservice.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthMiddleware extends GenericFilterBean {
    private final UserService userService;

    public AuthMiddleware(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String authHeader = httpRequest.getHeader("Authorization");
        if(authHeader==null){
            httpResponse.sendError(403,"Missing token");
            return;
        }
        String[] authHeaderArr = authHeader.split("Bearer ");
        if (authHeaderArr.length<=1 || authHeaderArr[1] == null){
            httpResponse.sendError(403,"Invalid/expired token 1");
            return;
        }

        String token = authHeaderArr[1];
        try{
            String userId = JwtToken.getClaim(token);
            User user = userService.getUserById(userId);
            httpRequest.setAttribute("user",user);
        } catch (Exception e){
            e.printStackTrace();
            httpResponse.sendError(403,"Invalid/expired token 3");
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);


    }
}
