package com.yi.backcli.entity;

public class AccountLogin extends BaseEntity {

    private static final long serialVersionUID = -2134847606299943426L;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountLogin() {
    }

    public AccountLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
