package com.yi.backcli.service.impl;

import com.yi.backcli.dao.ConsumptionDao;
import com.yi.backcli.dao.DailyRecordDao;
import com.yi.backcli.dao.ToDoDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.entity.DailyRecord;
import com.yi.backcli.exception.ExistsException;
import com.yi.backcli.service.DailyRecordService;
import com.yi.backcli.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DailyRecordServiceImpl implements DailyRecordService {

    private final DailyRecordDao dailyRecordDao;

    public DailyRecordServiceImpl(DailyRecordDao dailyRecordDao, ToDoDao toDoDao, ConsumptionDao consumptionDao) {
        this.dailyRecordDao = dailyRecordDao;
    }

    @Override
    public Result create(Long accountId, Map<String, Object> map) {
        Date recordTime = new Date((Long) map.get("recordTime"));

        DailyRecord recordByTime = dailyRecordDao.findRecordByTime(accountId, recordTime);

        if (recordByTime != null) {
            throw new ExistsException("记录已创建！");
        }

        DailyRecord record = new DailyRecord();
        record.setAccountId(accountId);
        record.setRecordTime(recordTime);
        dailyRecordDao.create(record);

        record.setDeprecated(false);
        record.setToDoList(Collections.emptyList());
        record.setConsumptionList(Collections.emptyList());
        return ResultUtils.success(record);
    }

    @Override
    public Result findFullRecordByTime(Long accountId, Long recordTime) {
        Date time = new Date(recordTime);
        DailyRecord record = dailyRecordDao.findFullRecordByTime(accountId, time);
        return ResultUtils.success(record);
    }

}
