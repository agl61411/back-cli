package com.yi.backcli.entity;

import java.util.Date;
import java.util.List;

public class DailyRecord extends BaseEntity {

  private Date recordTime;

  private Long accountId;

  private Boolean finished;

  private List<ToDo> toDoList;

  private List<Consumption> consumptionList;

  public DailyRecord() {
  }

  public DailyRecord(Date recordTime, Long accountId, List<ToDo> toDoList, List<Consumption> consumptionList) {
    this.recordTime = recordTime;
    this.accountId = accountId;
    this.toDoList = toDoList;
    this.consumptionList = consumptionList;
  }

  public Date getRecordTime() {
    return recordTime;
  }

  public void setRecordTime(Date recordTime) {
    this.recordTime = recordTime;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Boolean getFinished() {
    return finished;
  }

  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  public List<ToDo> getToDoList() {
    return toDoList;
  }

  public void setToDoList(List<ToDo> toDoList) {
    this.toDoList = toDoList;
  }

  public List<Consumption> getConsumptionList() {
    return consumptionList;
  }

  public void setConsumptionList(List<Consumption> consumptionList) {
    this.consumptionList = consumptionList;
  }
}
