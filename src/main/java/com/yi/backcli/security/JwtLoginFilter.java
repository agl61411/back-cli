package com.yi.backcli.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yi.backcli.dao.AccountDao;
import com.yi.backcli.dto.UserInfo;
import com.yi.backcli.entity.AccountInfo;
import com.yi.backcli.entity.JwtUserDetail;
import com.yi.backcli.util.HttpUtils;
import com.yi.backcli.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AccountDao accountDao;

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilter(request, response, chain);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String body = getBody(request);
        JSONObject jsonObject = JSON.parseObject(body);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(username, password, Collections.emptyList());

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        getRememberMeServices().loginSuccess(request, response, authResult);
        if (this.eventPublisher != null) {
            eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }

        JwtUserDetail detail = (JwtUserDetail) authResult.getPrincipal();
        Long accountId = detail.getAccountId();
        AccountInfo info = accountDao.findInfoByAccountId(accountId);
        UserInfo userInfo = new UserInfo(accountId, info.getId(), info.getUsername(), info.getNickname(), info.getType(), detail.getAuthorities(), JwtTokenUtils.generateToken(authResult));

        HttpUtils.write(response, 200, null, userInfo);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        HttpUtils.write(response, 0, failed.getMessage(), null);
    }

    private String getBody(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
