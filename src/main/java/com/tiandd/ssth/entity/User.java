package com.tiandd.ssth.entity;

public class User
{
  private int id;
  private String userName;
  private String passWord;
  private String openTime;
  private String expTime;
  private String effTime;

  public int getId()
  {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPassWord() {
    return this.passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getOpenTime() {
    return this.openTime;
  }

  public void setOpenTime(String openTime) {
    this.openTime = openTime;
  }

  public String getExpTime() {
    return this.expTime;
  }

  public void setExpTime(String expTime) {
    this.expTime = expTime;
  }

  public String getEffTime() {
    return this.effTime;
  }

  public void setEffTime(String effTime) {
    this.effTime = effTime;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String toString()
  {
    return "User{id=" + this.id + ", userName='" + this.userName + '\'' + ", passWord='" + this.passWord + '\'' + ", openTime='" + this.openTime + '\'' + ", expTime='" + this.expTime + '\'' + ", effTime='" + this.effTime + '\'' + '}';
  }
}
