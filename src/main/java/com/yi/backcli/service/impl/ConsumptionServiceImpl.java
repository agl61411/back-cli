package com.yi.backcli.service.impl;

import com.yi.backcli.dao.ConsumptionDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.Consumption;
import com.yi.backcli.service.ConsumptionService;
import com.yi.backcli.util.ResultUtils;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {

    private final ConsumptionDao consumptionDao;

    public ConsumptionServiceImpl(ConsumptionDao consumptionDao) {
        this.consumptionDao = consumptionDao;
    }

    @Override
    public Result create(Consumption consumption) {
        consumptionDao.create(consumption);
        return ResultUtils.success(consumption.getId());
    }

}
