package com.yi.backcli.dao;

import com.yi.backcli.entity.Consumption;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumptionDao {

    void create(Consumption consumption);

}
