package com.yi.backcli.entity;

import com.yi.backcli.enums.ConsumptionType;

import java.math.BigDecimal;

public class Consumption extends BaseEntity {

  private BigDecimal money;

  private String content;

  private ConsumptionType type;

  private Long recordId;

  public Consumption() {
  }

  public Consumption(BigDecimal money, String content, ConsumptionType type, Long recordId) {
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

  public ConsumptionType getType() {
    return type;
  }

  public void setType(ConsumptionType type) {
    this.type = type;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }
}
