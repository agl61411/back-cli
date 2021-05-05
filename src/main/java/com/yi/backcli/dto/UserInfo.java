package com.yi.backcli.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserInfo {

    private Long accountId;

    private Long infoId;

    private String username;

    private String nickname;

    private String type;

    private Collection<GrantedAuthority> authorities;

    private String token;

    public UserInfo() {
    }

    public UserInfo(Long accountId, Long infoId, String username, String nickname, String type, Collection<GrantedAuthority> authorities, String token) {
        this.accountId = accountId;
        this.infoId = infoId;
        this.username = username;
        this.nickname = nickname;
        this.type = type;
        this.authorities = authorities;
        this.token = token;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
