package com.yi.backcli.service;

import com.yi.backcli.dto.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {

    Result login(Map<String, Object> map, HttpServletRequest request);

}
