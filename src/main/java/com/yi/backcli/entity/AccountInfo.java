package com.yi.backcli.entity;

import com.yi.backcli.enums.AccountType;

public class AccountInfo extends BaseEntity {

  private String username;

  private String nickname;

  private AccountType type;

  private Long accountId;

  public AccountInfo() {

  }

  public AccountInfo(String username, String nickname, AccountType type, Long accountId) {
    this.username = username;
    this.nickname = nickname;
    this.type = type;
    this.accountId = accountId;
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

  public AccountType getType() {
    return type;
  }

  public void setType(AccountType type) {
    this.type = type;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }
}
