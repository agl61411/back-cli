package com.yi.backcli.entity;

import java.math.BigDecimal;

public class ConsumptionItems extends BaseEntity {

  private BigDecimal money;

  private String content;

  private String type;

  private Long recordId;

  public ConsumptionItems() {
  }

  public ConsumptionItems(BigDecimal money, String content, String type, Long recordId) {
    this.money = money;
    this.content = content;
    this.type = type;
    this.recordId = recordId;
  }

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }
}
