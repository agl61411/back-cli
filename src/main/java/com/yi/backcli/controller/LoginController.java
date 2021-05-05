package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        return loginService.login(map, request);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Result register(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        return loginService.register(map, request);
    }
}