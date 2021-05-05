package com.yi.backcli.dao;

import com.yi.backcli.entity.AccountInfo;
import com.yi.backcli.entity.AccountLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {

    AccountLogin findByUsername(String username);

    AccountInfo findInfoByAccountId(Long accountId);

    void create(AccountLogin accountLogin);

    void createInfo(AccountInfo accountInfo);
}
