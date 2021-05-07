package com.yi.backcli.controller;

import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.Consumption;
import com.yi.backcli.service.ConsumptionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/consumption")
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    public ConsumptionController(ConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result create(@RequestBody Consumption consumption) {
        return consumptionService.create(consumption);
    }
}
