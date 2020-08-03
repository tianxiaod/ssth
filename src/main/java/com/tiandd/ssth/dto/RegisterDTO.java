package com.tiandd.ssth.dto;

public class RegisterDTO
{
  private String userName;
  private String pass;
  private String checkPass;

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPass() {
    return this.pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getCheckPass() {
    return this.checkPass;
  }

  public void setCheckPass(String checkPass) {
    this.checkPass = checkPass;
  }

  public String toString()
  {
    return "RegisterDTO{userName='" + this.userName + '\'' + ", pass='" + this.pass + '\'' + ", checkPass='" + this.checkPass + '\'' + '}';
  }
}
