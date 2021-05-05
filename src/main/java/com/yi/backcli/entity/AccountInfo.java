package com.yi.backcli.entity;

public class AccountInfo extends BaseEntity {

  private String username;

  private String nickname;

  private String type;

  private Long accountId;

  public AccountInfo() {

  }

  public AccountInfo(String username, String nickname, String type, Long accountId) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }
}
