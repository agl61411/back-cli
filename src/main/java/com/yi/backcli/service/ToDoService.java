package com.yi.backcli.service;

import com.yi.backcli.dto.Result;

import java.util.Map;

public interface ToDoService {
    Result create(Map<String, Object> map);
}
