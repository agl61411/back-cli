package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        return loginService.login(map, request);
    }

}