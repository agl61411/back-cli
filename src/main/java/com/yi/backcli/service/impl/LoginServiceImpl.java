package com.yi.backcli.service.impl;

import com.yi.backcli.dao.AccountDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.dto.UserInfo;
import com.yi.backcli.entity.AccountInfo;
import com.yi.backcli.entity.AccountLogin;
import com.yi.backcli.entity.JwtUserDetail;
import com.yi.backcli.enums.AccountType;
import com.yi.backcli.exception.ExistsException;
import com.yi.backcli.security.JwtAuthenticationToken;
import com.yi.backcli.service.LoginService;
import com.yi.backcli.util.JwtTokenUtils;
import com.yi.backcli.util.ResultUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager manager;

    private final PasswordEncoder passwordEncoder;

    private final AccountDao accountDao;

    public LoginServiceImpl(AuthenticationManager manager, AccountDao accountDao, PasswordEncoder passwordEncoder) {
        this.manager = manager;
        this.accountDao = accountDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Result login(Map<String, Object> map, HttpServletRequest request) {
        String username = (String) map.get("username");
        String password = (String) map.get("password");

        JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        Authentication authentication = manager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtUserDetail detail = (JwtUserDetail) authentication.getPrincipal();
        Long accountId = detail.getAccountId();

        AccountInfo info = accountDao.findInfoByAccountId(accountId);
        UserInfo userInfo = new UserInfo(accountId, info.getId(), info.getUsername(), info.getNickname(), info.getType(), detail.getAuthorities(), JwtTokenUtils.generateToken(authentication));

        return ResultUtils.success(userInfo);
    }

    @Override
    @Transactional
    public void register(Map<String, Object> map) {
        String username = (String) map.get("username");

        AccountLogin user = accountDao.findByUsername(username);
        if (user != null) {
            throw new ExistsException("用户已存在！");
        }

        String password = (String) map.get("password");
        String nickname = (String) map.get("nickname");

        AccountLogin accountLogin = new AccountLogin(username, passwordEncoder.encode(password));

        accountDao.create(accountLogin);

        AccountInfo accountInfo = new AccountInfo(username, nickname, AccountType.NORMAL, accountLogin.getId());

        accountDao.createInfo(accountInfo);
    }

}




















