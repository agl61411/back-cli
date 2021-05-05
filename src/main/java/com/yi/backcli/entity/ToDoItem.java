package com.yi.backcli.entity;


public class ToDoItem extends BaseEntity {

  private String content;

  private String detail;

  private String type;

  private Boolean completed;

  private Long recordId;

  public ToDoItem() {
  }

  public ToDoItem(String content, String detail, String type, Boolean completed, Long recordId) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
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
