package com.yi.backcli.dao;

import com.yi.backcli.entity.DailyRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface DailyRecordDao {

    void create(DailyRecord record);

    DailyRecord findRecordByTime(Long accountId, Date recordTime);

    DailyRecord findFullRecordByTime(Long accountId, Date recordTime);
}
