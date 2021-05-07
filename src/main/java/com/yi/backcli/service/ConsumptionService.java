package com.yi.backcli.service;

import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.Consumption;

import java.util.Map;

public interface ConsumptionService {
    Result create(Consumption consumption);
}
