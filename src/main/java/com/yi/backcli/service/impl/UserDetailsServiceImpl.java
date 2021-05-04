package com.yi.backcli.service.impl;

import com.yi.backcli.entity.AccountLogin;
import com.yi.backcli.entity.JwtUserDetail;
import com.yi.backcli.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountLogin accountLogin = accountService.findByUsername(username);
        if (accountLogin == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        return new JwtUserDetail(username, accountLogin.getPassword(), Collections.emptyList());
    }
}
