package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;
import com.yi.backcli.service.ToDoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result create(@RequestBody ToDo toDo) {
        return toDoService.create(toDo);
    }
}
