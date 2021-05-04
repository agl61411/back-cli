package com.yi.backcli.dao;

import com.yi.backcli.entity.AccountLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountLoginDao {

    AccountLogin findByUsername(String username);
}
