package com.yi.backcli.service.impl;

import com.yi.backcli.dao.AccountDao;
import com.yi.backcli.entity.AccountLogin;
import com.yi.backcli.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public AccountLogin findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

}
