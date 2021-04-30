package com.yi.backcli.controller;

import com.yi.backcli.util.ResultUtils;
import com.yi.backcli.dto.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Result hello() {
        return ResultUtils.success("Hello World!");
    }

}
