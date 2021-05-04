package com.yi.backcli.service.impl;

import com.yi.backcli.dao.AccountLoginDao;
import com.yi.backcli.entity.AccountLogin;
import com.yi.backcli.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountLoginDao accountLoginDao;

    @Autowired
    public void setAccountLoginDao(AccountLoginDao accountLoginDao) {
        this.accountLoginDao = accountLoginDao;
    }

    @Override
    public AccountLogin findByUsername(String username) {
        return accountLoginDao.findByUsername(username);
    }

}
