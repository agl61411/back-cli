package com.yi.backcli.dao;

import com.yi.backcli.entity.DailyRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface DailyRecordDao {

    void create(DailyRecord record);

    DailyRecord findRecordById(Long id, Long accountId);

    DailyRecord findRecordByTime(Long accountId, Date recordTime);
}
