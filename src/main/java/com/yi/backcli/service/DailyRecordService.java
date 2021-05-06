package com.yi.backcli.service;

import com.yi.backcli.dto.Result;

import java.util.Date;
import java.util.Map;

public interface DailyRecordService {

    Result create(Long accountId, Map<String, Object> map);

    Result findRecordById(Long accountId, Long id);
}
