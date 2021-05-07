package com.yi.backcli.service;

import com.yi.backcli.dto.Result;

import java.util.Map;

public interface DailyRecordService {

    Result create(Long accountId, Map<String, Object> map);

    Result findFullRecordByTime(Long accountId, Long recordTime);
}
