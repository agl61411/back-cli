package com.yi.backcli.security;

import com.yi.backcli.util.HttpUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String message;

        if (e instanceof BadCredentialsException) {
            message = e.getMessage();
        } else if (e instanceof InsufficientAuthenticationException) {
            message = "检测到未登录状态，请先登录";
        } else {
            message = e.getMessage();
        }

        HttpUtils.write(response, 0, message, null);
    }
}
