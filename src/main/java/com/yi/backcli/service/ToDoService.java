package com.yi.backcli.service;

import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;

import java.util.Map;

public interface ToDoService {
    Result create(ToDo toDo);
}
