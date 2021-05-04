package com.yi.backcli.controller;

import com.yi.backcli.dto.LoginForm;
import com.yi.backcli.dto.Result;
import com.yi.backcli.security.JwtAuthenticationToken;
import com.yi.backcli.util.ResultUtils;
import com.yi.backcli.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);

        return ResultUtils.success(token);
    }
}
