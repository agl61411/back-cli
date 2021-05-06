package com.yi.backcli.entity;


import com.yi.backcli.enums.ToDoType;

public class ToDo extends BaseEntity {

  private String content;

  private String detail;

  private ToDoType type;

  private Boolean completed;

  private Long recordId;

  public ToDo() {
  }

  public ToDo(String content, String detail, ToDoType type, Long recordId) {
    this.content = content;
    this.detail = detail;
    this.type = type;
    this.recordId = recordId;
  }

  public ToDo(String content, String detail, ToDoType type, Boolean completed, Long recordId) {
    this.content = content;
    this.detail = detail;
    this.type = type;
    this.completed = completed;
    this.recordId = recordId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public ToDoType getType() {
    return type;
  }

  public void setType(ToDoType type) {
    this.type = type;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }
}
