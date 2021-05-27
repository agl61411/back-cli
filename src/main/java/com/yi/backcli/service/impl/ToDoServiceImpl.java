package com.yi.backcli.service.impl;

import com.yi.backcli.dao.ToDoDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;
import com.yi.backcli.security.GrantedAuthorityImpl;
import com.yi.backcli.service.ToDoService;
import com.yi.backcli.util.ResultUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public Result update(ToDo toDo) {
        toDoDao.update(toDo);
        return ResultUtils.success("更新TODO项成功");
    }

    @Override
    public Result complete(Map<String, Object> map) {
        Object obj = map.get("ids");
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("参数错误(ids)");
        }

        List<?> ids = (ArrayList<?>)obj;
        toDoDao.complete(ids);
        return ResultUtils.success("操作成功");
    }

    @Override
    public Result deprecate(Map<String, Object> map) {
        Object obj = map.get("ids");
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("参数错误(ids)");
        }

        List<?> ids = (ArrayList<?>)obj;
        toDoDao.deprecate(ids);
        return ResultUtils.success("操作成功");
    }

}
