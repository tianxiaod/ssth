package com.tiandd.ssth.entity;

public class Content
{
  private long id;
  private long userId;
  private String createTime;
  private String content;
  private String status;
  private String updateTime;
  private long forwardUser;

  public long getId()
  {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId()
  {
    return this.userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getCreateTime()
  {
    return this.createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getContent()
  {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getStatus()
  {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUpdateTime()
  {
    return this.updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public long getForwardUser()
  {
    return this.forwardUser;
  }

  public void setForwardUser(long forwardUser) {
    this.forwardUser = forwardUser;
  }
}
