package com.yi.backcli.service.impl;

import com.yi.backcli.dao.AccountDao;
import com.yi.backcli.dto.Result;
import com.yi.backcli.dto.UserInfo;
import com.yi.backcli.entity.AccountInfo;
import com.yi.backcli.entity.JwtUserDetail;
import com.yi.backcli.security.JwtAuthenticationToken;
import com.yi.backcli.service.LoginService;
import com.yi.backcli.util.JwtTokenUtils;
import com.yi.backcli.util.ResultUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager manager;

    private final AccountDao accountDao;

    public LoginServiceImpl(AuthenticationManager manager, AccountDao accountDao) {
        this.manager = manager;
        this.accountDao = accountDao;
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

}
