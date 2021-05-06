package com.yi.backcli.service.impl;

import com.yi.backcli.dao.ToDoDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;
import com.yi.backcli.enums.ToDoType;
import com.yi.backcli.service.ToDoService;
import com.yi.backcli.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoDao toDoDao;

    public ToDoServiceImpl(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    @Override
    public Result create(Map<String, Object> map) {
        String content = (String) map.get("content");
        String detail = (String) map.get("detail");
        ToDoType type = (ToDoType) map.get("type");
        Long recordId = (Long) map.get("recordId");

        ToDo toDo = new ToDo(content, detail, type, recordId);
        toDoDao.create(toDo);

        return ResultUtils.success(toDo.getId());
    }

}
