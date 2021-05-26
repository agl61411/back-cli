package com.yi.backcli.dao;

import com.yi.backcli.entity.ToDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoDao {

    void create(ToDo toDo);

    void update(ToDo toDo);

    void complete(Integer[] ids);
}
