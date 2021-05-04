package com.yi.backcli.service;

import com.yi.backcli.entity.AccountLogin;

public interface AccountService {

    AccountLogin findByUsername(String username);
}
