package com.yi.backcli.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtUserDetail extends User {

    private static final long serialVersionUID = -600563655240097000L;

    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public JwtUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, Long accountId) {
        super(username, password, authorities);
        this.accountId = accountId;
    }

    public JwtUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long accountId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.accountId = accountId;
    }
}
