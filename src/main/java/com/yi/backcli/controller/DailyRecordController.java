package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.service.DailyRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/record")
public class DailyRecordController {

    private final DailyRecordService dailyRecordService;

    public DailyRecordController(DailyRecordService dailyRecordService) {
        this.dailyRecordService = dailyRecordService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result create(@RequestHeader(name = "account_id")Long accountId, @RequestBody Map<String, Object> map) {
        return dailyRecordService.create(accountId, map);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findRecordById(@RequestHeader(name = "account_id")Long accountId, @PathVariable Long id) {
        return dailyRecordService.findRecordById(accountId, id);
    }
}
