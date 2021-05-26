package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.ToDo;
import com.yi.backcli.service.ToDoService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody ToDo toDo) {
        return toDoService.update(toDo);
    }

    @RequestMapping(value = "/complete", method = RequestMethod.PUT)
    public Result complete(@RequestBody Map<String, Object> map) {
        return toDoService.complete(map);
    }
}
