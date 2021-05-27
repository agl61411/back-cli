package com.yi.backcli.service;

import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;

import java.util.Map;

public interface ToDoService {
    Result create(ToDo toDo);

    Result update(ToDo toDo);

    Result complete(Map<String, Object> map);

    Result deprecate(Map<String, Object> map);
}
