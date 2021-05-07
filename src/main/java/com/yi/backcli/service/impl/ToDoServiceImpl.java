package com.yi.backcli.service.impl;

import com.yi.backcli.dao.ToDoDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;
import com.yi.backcli.service.ToDoService;
import com.yi.backcli.util.ResultUtils;
import org.springframework.stereotype.Service;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoDao toDoDao;

    public ToDoServiceImpl(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    @Override
    public Result create(ToDo toDo) {
        toDoDao.create(toDo);
        return ResultUtils.success(toDo.getId());
    }

}
