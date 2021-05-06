package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result create(@RequestBody Map<String, Object> map) {
        return toDoService.create(map);
    }
}
