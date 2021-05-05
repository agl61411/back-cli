package com.yi.backcli.entity;

import java.util.Date;
import java.util.List;

public class DailyRecord extends BaseEntity {

  private Date recordTime;

  private List<ToDoItem> toDoList;

  private List<ConsumptionItems> consumptionList;

  public DailyRecord() {
  }

  public DailyRecord(Date recordTime, List<ToDoItem> toDoList, List<ConsumptionItems> consumptionList) {
    this.recordTime = recordTime;
    this.toDoList = toDoList;
    this.consumptionList = consumptionList;
  }

  public Date getRecordTime() {
    return recordTime;
  }

  public void setRecordTime(Date recordTime) {
    this.recordTime = recordTime;
  }

  public List<ToDoItem> getToDoList() {
    return toDoList;
  }

  public void setToDoList(List<ToDoItem> toDoList) {
    this.toDoList = toDoList;
  }

  public List<ConsumptionItems> getConsumptionList() {
    return consumptionList;
  }

  public void setConsumptionList(List<ConsumptionItems> consumptionList) {
    this.consumptionList = consumptionList;
  }
}
